package main

import (
	"calculate/mathops"
	"fmt"
	"os"
)

func main() {
	var op string
	var num1, num2 float64
	var err error

	fmt.Println("기호 입력(+, -, *, /)을 한뒤 2개의 숫자를 입력해주세요")
	_, err = fmt.Scanf("%s %f %f", &op, &num1, &num2)
	if err != nil {
		fmt.Println("Invalid input:", err)
		return
	}

	switch op {
	case "+":
		fmt.Println("Result:", Add(num1, num2))
	case "-":
		fmt.Println("Result:", Subtract(num1, num2))
	case "*":
		fmt.Println("Result:", mathops.Multiply(num1, num2))
	case "/":
		if num2 == 0 {
			fmt.Println("Error: Division by zero")
			os.Exit(1)
		}
		fmt.Println("Result:", mathops.Divide(num1, num2))
	default:
		fmt.Println("Unsupported operation:", op)
	}
}
