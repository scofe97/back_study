package main

import (
	"crypto/tls"
	"fmt"               // 표준 출력을 위한 패키지
	"log"               // 로깅을 위한 패키지
	"net/http"          // HTTP 프로토콜을 다루기 위한 패키지
	"net/http/httputil" // HTTP 요청 정보를 확인하기 위한 유틸리티 패키지
)

// handler는 HTTP 요청을 받아 처리하는 함수
func handler(w http.ResponseWriter, r *http.Request) {
	dump, err := httputil.DumpRequest(r, true) // 요청의 전체 내용을 가져옴
	if err != nil {
		http.Error(w, fmt.Sprint(err), http.StatusInternalServerError) // 에러 발생 시 내부 서버 에러로 응답
		return
	}
	fmt.Println(string(dump))                           // 서버 콘솔에 요청 내용 출력
	fmt.Fprintf(w, "<html><body>hello</body></html>\n") // 클라이언트에 간단한 HTML 페이지 응답
}

// main 함수는 서버를 시작하고 요청을 기다리는 주 함수
func main() {
	server := &http.Server{
		TLSConfig: &tls.Config{
			ClientAuth: tls.RequireAndVerifyClientCert,
			MinVersion: tls.VersionTLS12,
		},
		Addr: ":18443",
	}

	http.HandleFunc("/", handler)              // "/" 경로에 대한 요청을 handler 함수로 처리하도록 설정
	log.Println("start http listening :18443") // 로그에 서버 시작 메시지 출력
	err := server.ListenAndServeTLS("server.crt", "server.key")
	log.Println(err)
}

// curl --http1.0 http://localhost:18888/greeting
// curl --http1.0 --get --data-urlencode "search workd" http://localhost:18888
// curl -v --http1.0 http://localhost:18888/greeting
//
