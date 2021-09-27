package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {

	aliceReadyChannel := make(chan bool)
	bobReadyChannel := make(chan bool)

	fmt.Println("Let's go for a walk!")

	go doSomething("Alice", "getting ready", 60, 90, aliceReadyChannel)
	go doSomething("Bob", "getting ready", 60, 90, bobReadyChannel)

	select {
	case <-aliceReadyChannel:
		<-bobReadyChannel
	case <-bobReadyChannel:
		<-aliceReadyChannel
	}

	fmt.Println("Arming alarm")
	go armAlarm()

	go doSomething("Alice", "putting on shoes", 35, 45, aliceReadyChannel)
	go doSomething("Bob", "putting on shoes", 35, 45, bobReadyChannel)

	select {
	case <-aliceReadyChannel:
		<-bobReadyChannel
	case <-bobReadyChannel:
		<-aliceReadyChannel
	}

	fmt.Println("Exiting and locking the door")

	time.Sleep(100 * time.Second)
}

func doSomething(name string, action string, min int, max int, ch chan bool) {
	fmt.Println(name, " started ", action)
	dur := min + rand.Intn(max-min)
	time.Sleep(time.Duration(dur) * time.Second)
	fmt.Println(name, " spent ", dur, " seconds ", action)
	ch <- true
}

func armAlarm() {
	fmt.Println("Alarm is counting down.")
	time.Sleep(60 * time.Second)
	fmt.Println("Alarm is armed")
}