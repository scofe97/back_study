package main

import (
	"io"
	"net/http"
	"os"
	"time"
)

func handlerChunkedFileDownload(w http.ResponseWriter, r *http.Request) {
	filePath := "./test.ttf" // 서버에 저장된 파일 경로
	file, err := os.Open(filePath)
	if err != nil {
		http.Error(w, "File not found.", http.StatusNotFound)
		return
	}
	defer file.Close()

	// 클라이언트에게 파일 다운로드를 알리는 헤더 설정
	w.Header().Set("Content-Type", "application/octet-stream")
	w.Header().Set("Content-Disposition", "attachment; filename=\""+file.Name()+"\"")
	w.Header().Set("Transfer-Encoding", "chunked")

	// 파일을 청크로 나누어 전송
	buffer := make([]byte, 8192) // 4KB 크기의 버퍼
	for {
		n, err := file.Read(buffer)
		if err == io.EOF {
			break // 파일 끝에 도달
		}
		if err != nil {
			http.Error(w, "Error reading file.", http.StatusInternalServerError)
			return
		}

		// 버퍼의 내용을 응답으로 작성
		w.Write(buffer[:n])
		flusher, _ := w.(http.Flusher)
		flusher.Flush()                  // 클라이언트로 청크 전송
		time.Sleep(1 * time.Millisecond) // 청크 사이의 지연 시간 (필요에 따라 조절)
	}
}

func main() {
	http.HandleFunc("/download", handlerChunkedFileDownload)
	http.ListenAndServe(":18888", nil)
}
