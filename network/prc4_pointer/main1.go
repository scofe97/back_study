package main

import (
	"fmt"
)

func main() {
	var a int = 10
	var b int = a
	var p *int = &a // a의 주소를 포인터 p에 할당

	fmt.Println("a의 값:", a)   // a의 값을 출력
	fmt.Println("a의 주소:", &a) // a의 메모리 주소 출력

	fmt.Println("b의 값:", b)
	fmt.Println("b의 주소:", &b)

	fmt.Println("p의 값:", p)   // 포인터 p에 저장된 주소 출력
	fmt.Println("*p의 값:", *p) // 포인터 p를 통해 a의 값을 간접적으로 출력

	*p = 20                     // 포인터 p를 통해 a의 값을 변경
	fmt.Println("a의 새로운 값:", a) // 변경된 a의 값 출력
	fmt.Println("b의 새로운 값:", b) // 변경된 a의 값 출력
}
