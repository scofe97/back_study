package main

import (
	"fmt"
	"net/http"

	"github.com/gorilla/websocket"
)

// 업그레이더 설정: HTTP 연결을 웹소켓으로 업그레이드하는 데 사용
var upgrader = websocket.Upgrader{
	// 모든 도메인에서의 요청을 허용
	CheckOrigin: func(r *http.Request) bool {
		return true
	},
}

// 연결된 클라이언트들을 저장하기 위한 맵
var clients = make(map[*websocket.Conn]bool)

// 메시지를 전달하기 위한 채널
var broadcast = make(chan Message)

// 메시지 구조체
type Message struct {
	Username string `json:"username"`
	Message  string `json:"message"`
}

func main() {
	// 파일 서버 설정: 현재 디렉토리의 파일을 제공
	fs := http.FileServer(http.Dir("./"))
	http.Handle("/", fs)
	// 웹소켓 핸들러 설정
	http.HandleFunc("/ws", handleConnections)

	// 메시지 처리 고루틴 시작
	go handleMessages()

	// 서버 시작
	fmt.Println("HTTP server started on :8080")
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		fmt.Println("ListenAndServe: ", err)
	}
}

// 웹소켓 연결을 처리하는 함수
func handleConnections(w http.ResponseWriter, r *http.Request) {
	// HTTP 요청을 웹소켓 연결로 업그레이드
	ws, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		fmt.Println(err)
		return
	}
	defer ws.Close()

	// 새로운 클라이언트를 맵에 추가
	clients[ws] = true

	// 무한 루프: 클라이언트로부터 메시지를 읽고 브로드캐스트 채널로 전달
	for {
		var msg Message
		err := ws.ReadJSON(&msg)
		if err != nil {
			fmt.Println("error: ", err)
			// 에러 발생 시 클라이언트를 맵에서 제거
			delete(clients, ws)
			break
		}
		broadcast <- msg
	}
}

// 메시지를 처리하고 모든 클라이언트에 전달하는 함수
func handleMessages() {
	for {
		// 브로드캐스트 채널에서 메시지 수신
		msg := <-broadcast
		// 모든 클라이언트에 메시지 전송
		for client := range clients {
			err := client.WriteJSON(msg)
			if err != nil {
				fmt.Println("error: ", err)
				client.Close()
				delete(clients, client)
			}
		}
	}
}
