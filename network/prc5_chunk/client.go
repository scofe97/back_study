package main

import (
	"fmt"
	"io"
	"log"
	"net/http"
	"os"
)

func main() {
	// 서버에서 파일 다운로드
	resp, err := http.Get("http://localhost:18888/download")
	if err != nil {
		log.Fatal(err)
	}
	defer resp.Body.Close()

	// 로컬 파일로 저장
	outFile, err := os.Create("downloaded_file.msi") // 로컬에 저장할 파일 이름
	if err != nil {
		log.Fatal(err)
	}
	defer outFile.Close()

	// 데이터 청크로 읽고 파일에 쓰면서 정보 출력
	buffer := make([]byte, 4096) // 4KB 크기의 버퍼
	totalBytes := 0
	for {
		n, err := resp.Body.Read(buffer)
		if err == io.EOF {
			break // 파일 끝에 도달
		}
		if err != nil {
			log.Fatal("Error reading chunk:", err)
		}

		// 로컬 파일에 쓰기
		if _, err := outFile.Write(buffer[:n]); err != nil {
			log.Fatal("Error writing to file:", err)
		}

		// 읽은 청크 크기 로그
		totalBytes += n
		fmt.Printf("Downloaded %d bytes for this chunk\n", n)
	}

	fmt.Printf("Total downloaded: %d bytes\n", totalBytes)
	fmt.Println("File downloaded successfully")
}
