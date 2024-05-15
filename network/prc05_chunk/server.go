package main

import (
	"fmt"
	"net"
	"os"
)

func main() {
	listener, err := net.Listen("tcp", "localhost:9999")
	if err != nil {
		fmt.Println("Error creating listener:", err)
		os.Exit(1)
	}
	defer listener.Close()
	fmt.Println("Server is listening on localhost:9999")

	for {
		conn, err := listener.Accept()
		if err != nil {
			fmt.Println("Error accepting connection:", err)
			continue
		}
		go handleConnection(conn)
	}
}

func handleConnection(conn net.Conn) {
	defer conn.Close()

	// 전송할 전체 데이터
	msg := "Hello from server. This data will be sent in chunks. Each chunk has its own part of the whole message."
	data := []byte(msg)

	// 청크 사이즈 정의
	chunkSize := 5

	// 데이터를 청크로 나누어 전송
	for i := 0; i < len(data); i += chunkSize {
		end := i + chunkSize
		if end > len(data) {
			end = len(data)
		}
		_, err := conn.Write(data[i:end])
		if err != nil {
			fmt.Println("Error writing to connection:", err)
			return
		}
	}
}
