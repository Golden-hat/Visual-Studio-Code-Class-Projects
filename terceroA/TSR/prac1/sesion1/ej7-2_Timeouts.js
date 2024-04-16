
//Uso de operaciones asíncronas, aquí modeladas con la función setTimeout.
//Note el valor de i asociado a las ejecuciones de las temporizaciones.


for (var i=0; i<10; i++) {
	setTimeout ( function() {console.log(i)}, i*1000);
}

/**
	Question 1. Why does it always print 10?

Debido al hoisting y a las clausuras. El bucle entero se ejecuta, y para el momento en que
el timeout finaliza para cada llamada de la función anónima, var i se printea, pero debido a que
esta variable es compartida por todas las llamadas, todas printean lo mismo (no es exclusiva al
bloque de iteración, sino a la llamada completa)
	
	Question 2. Why does it print a message every second?

Porque i en el momento en que se invoca la función SÍ que es el valor "esperado" (el que debería
printearse pero no lo hace debido a lo mencionado)

	Question 3. Why does the program terminate when printing 10 messages to the console? Why didn't it
	terminate when executing the last line of code in the program?

Porque el timeout hace que la primera línea de código ejecutada sea necesariamente la última

 */

console.log("Terminado script. Valor actual de i: " + i);
