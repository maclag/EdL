package main

import "fmt"

// Fatorial
func main() {
	num := 5
	fmt.Println(factorial(num))
}

func factorial (num int) int {
	if num == 0{
		return 1
	}
	return num * factorial(num-1)
}