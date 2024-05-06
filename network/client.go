package main

import (
	"crypto/tls"
	"crypto/x509"
	"io/ioutil"
	"log"               // 로깅을 위한 패키지
	"net/http"          // HTTP 프로토콜을 다루기 위한 패키지
	"net/http/httputil" // HTTP 요청 정보를 확인하기 위한 유틸리티 패키지
)

func main() {
	// 인증서를 읽어들인다.
	cert, err := ioutil.ReadFile("ca.crt")
	if err != nil {
		panic(err)
	}

	certPool := x509.NewCertPool()
	certPool.AppendCertsFromPEM(cert)
	tlsConfig := &tls.Config{
		RootCAs: certPool,
	}
	tlsConfig.BuildNameToCertificate()

	// 클라이언트 작성
	client := &http.Client{
		Transport: &http.Transport{
			TLSClientConfig: tlsConfig,
		},
	}

	// 통신한다.
	resp, err := client.Get("https://example.com:18443")
	if err != nil {
		panic(err)
	}

	defer resp.Body.Close()
	dump, err := httputil.DumpResponse(resp, true)
	if err != nil {
		panic(err)
	}

	log.Println(string(dump))

}
