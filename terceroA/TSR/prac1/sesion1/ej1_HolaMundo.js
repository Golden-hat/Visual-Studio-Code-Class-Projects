'use strict';
// Use strict indicates that the code should be run in "STRICT mode"
// Strict mode won't allow running a program with undeclared variables, for example

console.log ("hola mundo")

let cnt = 0;
function imprime (msg) {
	console.log (cnt++ + ".- " + msg);
}

imprime ("hola mundo")
imprime ("adios")
