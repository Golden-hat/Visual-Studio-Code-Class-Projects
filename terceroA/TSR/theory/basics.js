/*
 * Javascript is an INTERPRETED LANGUAGE. THERE is NO COMPILER
 * as such, the program will stop only when errors are detected
 * at runtime.
 *
 * It is an ASYNCHRONOUS, SINGLE THREADED language ran by the Node.js
 * runtime environment. As such, there is no need for synchronization
 * mechanisms. It is an EVENT DRIVEN LANGUAGE. EVENTS are put into 
 * a QUEUE. Javascript uses lambda functions extensively, and it also
 * treats functions as first-class citizens.
 *
 * Main features of JSCRIPT:
 * 	- Imperative and structured.
 * 	- Functional programming.
 * 	- Object oriented programming.
 * 	- Related to java, python, perl, scheme...
 *
 * Its interpretation is embedded in web browsers
 * (as it was born in order to provide dynamical behaviour to webpages).
 *
 * */

/*
 * to declare a variable...
 * Notice that let can't accept that another variable with the same name is declared.
 *
 * var though, however, is more relaxed
 * */

let x = 0

// notice that this variable has NO assigned intial type. We may take advantage of this.

console.log(x)

x = "2"
x = x*7

console.log(x)

var y = "hola"

console.log(y)

var y = "a todos"

console.log(y)

/*
 * to declare a function...
 **/

function printFor(x, repetitions){
	/*
	 * variables in jscript behave... interestingly. A variable declared inside a function
	 * without the let nor var keywords belongs to the global scope. If we want to keep it
	 * constrained to the scope of the function, we should use either let or var
	 */
	GLOBAL_VARIABLE = "EXAMPLE of GLOBAL VARIABLE"

	for(let i = 0; i < repetitions; i++){
		console.log(x)
	}
}

printFor("hola", 10)
console.log(GLOBAL_VARIABLE)

/**
 * Javascript has a concept called CLOSURES. IT is a composition of the function plus
 * all the variables that are used by it. A function remembers the envirnoment in which it
 * is created. An exmple of closure is the following:
 */

function moz(){
	let name = "Mozilla"
	// lambda function
	return () => {console.log(name)}
}

let myFunction = moz();
myFunction()

/**
 * With this very concept we can create what we call FUNCTION FACTORIES.
 * Let's imagine a FF (Function Factory) that enables us to create functions
 * that multiply values by a given x value
 */

function mult(x){
	return (y) => {	
		console.log(x*y)
		return x*y
	}
}

let triple = mult(3);
let result = triple(21);

// Más información respecto a las closures y a las funciones en la primera sesión de la práctica.