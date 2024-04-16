'use strict'

console.log ("uno")

setTimeout ( () => {
	console.log ("dos")
}, 100)

for (let i=0; i<1000000000; i++) {}

setTimeout ( () => {
	console.log ("tres")
}, 99)

setTimeout ( () => {
	console.log ("cuatro")
}, 0)

console.log ("cinco")

/**
 *  Question 1 . Why do we see the message "cinco" before "cuatro"

Because the timeout function implicitly adds some time of execution

	Question 2 . Why do we see “dos” before “tres” or “tres” before “dos”? To explain your answer to this
	question, run the program several times, modifying the number of iterations of the loop so that it does
	100, 1000, 10000, 100000 iterations.

Because the iterations must be performed before calling an.func s.timeout for three. We only need
the iteration to take more than 1 time unit for three to be displayed before two


 */
