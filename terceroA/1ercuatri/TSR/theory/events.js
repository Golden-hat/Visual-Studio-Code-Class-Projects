function fibo(n) {
    return (n < 2) ? 1 : fibo(n - 2) + fibo(n - 1)
}

function showMessage(m, u) {
    console.log(m + ": The result is: " + u)
}

console.log("Starting the process...")

// Wait for 10 ms in order to show the message...
setTimeout(function () {
    console.log("M1: My first message...")
}, 10)

// Several seconds are needed in order to
// complete this call: fibo(40)
let j = fibo(40)

// M2 is written before M1 is shown. Why?
/**
 * Because the fibonacci calculation enters the
 * call stack before the timeout M1 message does.
 * 
 * This is because the call stack can't be repopulated
 * with the events in the queue unless it is empty.
 * 
 * Only the things in the call stack are executed.
 */
showMessage("M2", j)

// M3 is written after M1. Why?
/**
 * Because it is the last thing to enter the calls stack
 */
setTimeout(function () {
    showMessage("M3", j)
}, 1)