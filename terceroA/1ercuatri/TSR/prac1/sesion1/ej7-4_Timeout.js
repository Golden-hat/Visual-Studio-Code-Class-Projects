//Uso de la sentencia let.

var i = 0;

do {
	let k = i;
	setTimeout(function(){console.log(k)},k*1000);
	i++;    
} while (i<10);

console.log("Terminado codigo, valor de i: " + i);

/**
	Question 1. Modify the program so that it declares the variable inside the “do” block using “var”. Explain
	why now the operation is different.

Debido al hoisting y a las clausuras. El bucle entero se ejecuta, y para el momento en que
el timeout finaliza para cada llamada de la función anónima, var i se printea, pero debido a que
esta variable es compartida por todas las llamadas, todas printean lo mismo (no es exclusiva al
bloque de iteración, sino a la llamada completa).

Por esto, declarar la variable let k con var cambiaría la funcionalidad.

 */