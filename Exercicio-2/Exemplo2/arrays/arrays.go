package main

import "fmt"

func main() {
	// Imprime cada elemento com sua respectiva posição
	EvenNum := [5]int{0, 2, 4, 6, 8}
	for i, value := range EvenNum {
		fmt.Println(value, i)
	}

	fmt.Println()

	// Divide o array a partir da 3ª posição => [2, 1]
	numSlice :=[]int{5, 4, 3, 2, 1}
	sliced := numSlice[3:5]
	fmt.Println(sliced)
}