package main

import (
	"fmt"
	"net/http"
	"time"
)

func handlerChunkedResponse(w http.ResponseWriter, r *http.Request) {
	flusher, ok := w.(http.Flusher)
	if !ok {
		panic("expected http.ResponseWriter to be an http.Flusher")
	}

	for i := 1; i <= 10; i++ {
		// 청크 데이터 전송
		fmt.Fprintf(w, "Chunk #%d\n", i)
		flusher.Flush()                    // 즉시 데이터를 클라이언트에게 전달
		time.Sleep(500 * time.Millisecond) // 청크 사이의 지연 시간
	}
}

func main() {
	http.HandleFunc("/chunked", handlerChunkedResponse)
	http.ListenAndServe(":18888", nil)
}
