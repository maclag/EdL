package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {

	aliceChannel := make(chan bool)
	bobChannel := make(chan bool)

	fmt.Println("Let's go for a walk!")

	go activity("Alice", "getting ready", 60, 90, aliceChannel)
	go activity("Bob", "getting ready", 60, 90, bobChannel)

	select {
	case <-aliceChannel:
		<-bobChannel
	case <-bobChannel:
		<-aliceChannel
	}

	fmt.Println("Arming alarm")
	go armAlarm()

	go activity("Alice", "putting on shoes", 35, 45, aliceChannel)
	go activity("Bob", "putting on shoes", 35, 45, bobChannel)

	select {
	case <-aliceChannel:
		<-bobChannel
	case <-bobChannel:
		<-aliceChannel
	}

	fmt.Println("Exiting and locking the door")

	time.Sleep(100 * time.Second)
}

func activity(name string, action string, min int, max int, ch chan bool) {
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