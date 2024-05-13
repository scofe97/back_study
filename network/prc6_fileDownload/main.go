package main

import (
	"io"
	"log"
	"net/http"
	"os"
	"strconv"
)

func main() {
	url := "https://dlcdn.apache.org/httpd/httpd-2.4.59.tar.bz2" // 대용량 파일 URL
	outputFile := "complete_largefile.zip"                       // 완성될 파일 이름
	partSize := 1024 * 1024                                      // 다운로드할 각 파트의 크기 (1MB)

	client := &http.Client{}

	outFile, err := os.Create(outputFile)
	if err != nil {
		log.Fatalf("Error creating file: %v", err)
	}
	defer outFile.Close()

	// 파일 나눠서 순차 다운로드
	for i := 0; ; i++ {
		start := i * partSize
		end := start + partSize - 1

		// Range 헤더 설정
		rangeHeader := "bytes=" + strconv.Itoa(start) + "-" + strconv.Itoa(end)
		log.Printf("Requesting bytes from %d to %d", start, end)

		req, err := http.NewRequest("GET", url, nil)
		if err != nil {
			log.Fatalf("Error creating request: %v", err)
		}
		req.Header.Add("Range", rangeHeader)
		req.Header.Set("User-Agent", "curl/7.64.1")

		// 요청 실행
		resp, err := client.Do(req)
		if err != nil {
			log.Fatalf("Error executing request: %v", err)
		}
		defer resp.Body.Close()

		// 응답 상태 로그
		log.Printf("Received status code: %d for range %d-%d", resp.StatusCode, start, end)

		if resp.StatusCode == http.StatusRequestedRangeNotSatisfiable {
			log.Println("Reached the end of the file.")
			break
		}

		// 파일의 일부분 쓰기
		written, err := io.Copy(outFile, resp.Body)
		if err != nil {
			log.Fatalf("Error writing to file: %v", err)
		}
		log.Printf("Written %d bytes for range %d-%d", written, start, end)

		// 206 Partial Content 이외의 응답 처리
		if resp.StatusCode != http.StatusPartialContent {
			log.Fatalf("Expected status 206, got %d", resp.StatusCode)
		}
	}

	log.Println("Download completed successfully!")
}
