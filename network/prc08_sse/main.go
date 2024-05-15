package main

import (
	"fmt"
	"log"
	"net/http"
	"sync"
	"time"
)

type client chan string // SSE 클라이언트는 문자열을 전송하는 채널

var (
	clientsA = make([]client, 0) // 그룹 A 클라이언트 리스트
	clientsB = make([]client, 0) // 그룹 B 클라이언트 리스트
	mu       sync.Mutex          // 클라이언트 리스트 접근을 보호하는 뮤텍스
)

func sseHandlerA(w http.ResponseWriter, r *http.Request) {
	c := make(client)
	defer close(c)

	mu.Lock()
	clientsA = append(clientsA, c)
	mu.Unlock()

	w.Header().Set("Access-Control-Allow-Origin", "*")
	w.Header().Set("Content-Type", "text/event-stream")
	w.Header().Set("Cache-Control", "no-cache")
	w.Header().Set("Connection", "keep-alive")

	notify := w.(http.CloseNotifier).CloseNotify()

	go func() {
		<-notify
		mu.Lock()
		for i, client := range clientsA {
			if client == c {
				clientsA = append(clientsA[:i], clientsA[i+1:]...)
				break
			}
		}
		mu.Unlock()
	}()

	for msg := range c {
		fmt.Fprintf(w, "data: %s\n\n", msg)
		if f, ok := w.(http.Flusher); ok {
			f.Flush()
		}
	}
}

func sseHandlerB(w http.ResponseWriter, r *http.Request) {
	c := make(client)
	defer close(c)

	mu.Lock()
	clientsB = append(clientsB, c)
	mu.Unlock()

	w.Header().Set("Access-Control-Allow-Origin", "*")
	w.Header().Set("Content-Type", "text/event-stream")
	w.Header().Set("Cache-Control", "no-cache")
	w.Header().Set("Connection", "keep-alive")

	notify := w.(http.CloseNotifier).CloseNotify()

	go func() {
		<-notify
		mu.Lock()
		for i, client := range clientsB {
			if client == c {
				clientsB = append(clientsB[:i], clientsB[i+1:]...)
				break
			}
		}
		mu.Unlock()
	}()

	for msg := range c {
		fmt.Fprintf(w, "data: %s\n\n", msg)
		if f, ok := w.(http.Flusher); ok {
			f.Flush()
		}
	}
}

func sendToGroup(clients []client, message string) {
	mu.Lock()
	defer mu.Unlock()
	for _, client := range clients {
		client <- message
	}
}

func main() {
	http.HandleFunc("/eventsA", sseHandlerA)
	http.HandleFunc("/eventsB", sseHandlerB)

	go func() {
		for {
			time.Sleep(5 * time.Second)
			sendToGroup(clientsA, "Group A: An important event has occurred!")
			sendToGroup(clientsB, "Group B: An important event has occurred!")
		}
	}()

	log.Println("SSE server running on port 3000")
	log.Fatal(http.ListenAndServe(":3000", nil))
}
