package main

import (
	"flag"
	"fmt"
)

func main() {
	// 사용자 이름 입력받기
	name := flag.String("name", "Guest", "이름을 입력하세요. 기본값은 'Guest'입니다.")

	// 사용자 나이 입력받기
	age := flag.Int("age", 0, "나이를 입력하세요. 기본값은 0입니다.")

	// 인사 메시지 활성화 여부
	greet := flag.Bool("greet", false, "인사 메시지를 활성화하려면 '-greet=true'를 입력하세요.")

	// Flag 파싱
	flag.Parse()

	// 조건에 따른 메시지 출력
	if *greet {
		fmt.Printf("Hello, %s!\n", *name)
		if *age > 0 {
			fmt.Printf("Wow, you are %d years old!\n", *age)
			if *age < 18 {
				fmt.Println("You are considered a minor in most countries.")
			} else if *age < 65 {
				fmt.Println("Enjoy your years of adulthood.")
			} else {
				fmt.Println("Enjoy your retirement.")
			}
		}
	} else {
		fmt.Println("Greeting not enabled. Use '-greet=true' to see the greeting message.")
	}
}
