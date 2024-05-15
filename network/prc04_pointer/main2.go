package main

import (
	"fmt"
)

// 포인터를 인자로 받아 그 포인터가 가리키는 값을 변경하는 함수
func increment(x *int) {
	*x = *x + 1 // 인자로 받은 포인터를 통해 값을 1 증가
}

func main() {
	var n int = 10
	fmt.Println("함수 호출 전 n의 값:", n) // 변경 전 값 출력

	increment(&n)                   // n의 주소를 함수에 전달
	fmt.Println("함수 호출 후 n의 값:", n) // 변경 후 값 출력
}
