package main

import (
	"fmt"
	"io"
	"net"
	"os"
)

func main() {
	conn, err := net.Dial("tcp", "localhost:9999")
	if err != nil {
		fmt.Println("Error connecting to server:", err)
		os.Exit(1)
	}
	defer conn.Close()

	var receivedData []byte
	buf := make([]byte, 1024) // 1024 바이트 크기의 버퍼

	for {
		n, err := conn.Read(buf)
		if err != nil {
			if err != io.EOF {
				fmt.Println("Error reading from connection:", err)
			}
			break
		}
		receivedData = append(receivedData, buf[:n]...)

		// 수신된 청크 출력
		fmt.Printf("Received chunk: %s\n", string(buf[:n]))
	}

	fmt.Println("Received message:", string(receivedData))
}
