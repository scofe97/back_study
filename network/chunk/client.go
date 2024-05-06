package main

import (
	"bufio"
	"fmt"
	"io"
	"log"
	"net/http"
)

func main() {
	// 서버의 청크 인코딩된 데이터 스트림에 연결
	resp, err := http.Get("http://localhost:18888/chunked")
	if err != nil {
		log.Fatal(err)
	}
	defer resp.Body.Close()

	// 데이터 스트림 읽기
	reader := bufio.NewReader(resp.Body)
	for {
		line, err := reader.ReadBytes('\n')
		if err == io.EOF {
			break // 데이터 스트림의 끝에 도달했을 때 반복 종료
		}
		fmt.Print(string(line)) // 청크 출력
	}
}
