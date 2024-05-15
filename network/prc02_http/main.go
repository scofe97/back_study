package main

import (
	"fmt"
	"net/http"
)

func main() {
	// 웹 페이지 루트에서 "Welcome to my website!" 메시지를 표시
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Welcome to my website!")
	})

	// 정적 파일 처리
	fs := http.FileServer(http.Dir("static/"))

	// /static/ 경로를 통해 정적 파일 제공
	http.Handle("/static/", http.StripPrefix("/static/", fs))

	// 포트 80에서 서버 시작
	err := http.ListenAndServe(":18080", nil)
	if err != nil {
		// 서버 시작 시 오류 처리
		fmt.Println("Error starting server:", err)
	}
}
