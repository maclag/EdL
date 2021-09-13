package main

import (
	"fmt"

	"example.com/greetings"
)

// Imprime a mensagem com nome
func main() {
	message := greetings.Hello("Maria")
	fmt.Println(message)
}