'use strict'

function f1 (a,b,c) {
	console.log ("recibo " + arguments.length + " argumentos")
	return a+b+c;
}

let result1 = f1 (1,2,3)
let result2 = f1 (1,2,3,4,5,6)
let result3 = f1 (1)

console.log ("result1: " + result1)
console.log ("result2: " + result2)
console.log ("result3: " + result3)

let vector = [1,2,3,4]

console.log ("resultv1: " + f1 (...vector))
console.log ("resultv2: " + f1 (vector))

/**
	Cuestión 1. Explica qué hace el pseudo-vector “arguments”. ¿Se puede acceder a los diferentes
	argumentos mediante este pseudo-vector?

Cuenta el numero de argumentos que se le pasa a una función.

	Cuestión 2. Al imprimir result3, vemos “NaN”. ¿Qué significa NaN y por qué vemos este resultado?

NaN es el resultado de sumar una variable a otra inicializada con "undefined". Lo vemos porque las
funciones cuyos argumentos no se completan inicializan estos argumentos faltantes a undefined.

	Cuestión 3. ¿Qué significan los 3 puntos suspensivos en la llamada a imprimir “resultv1” ?

Estos puntos ""descomprimen"" los elementos de la lista "vector". Se conocen como el operador 
"spread".

	Cuestión 4. Observa qué se imprime como resultado “resultv2”. ¿Por qué obtenemos este resultado?
	resultv2: 1,2,3,4undefinedundefined.

Al no descomprimirse, esta lista pasa como objeto. El resto, se inicializa a undefined. Por ello,
solo aparecen los elementos que la forman.

 */