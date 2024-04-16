
//Uso de operaciones asíncronas, aquí modeladas con la función setTimeout.
//Note el valor de índice asociado a las ejecuciones de las temporizaciones.


for(var i=0; i<10; i++) {
  setTimeout (function (índice){
	  return function(){
	  		console.log("índice: ",índice)
	  }
	}(i), i*1000);
}

/**
	Question 1. Identify the generating function and the closing function. When and how many times is the
	generator function called? How many closure functions are created and who calls them?

function(indice) es la función generadora, llamada 10 veces, la cual crea una closure por cada llamada

	Question 2. What is the content of the closures?

Su contenido es el índice que se le pasa.

	Question 3. What advantage does the use of closures offer in this example?

Consigue crear bloques de código independiente.

 */
console.log("Terminado script, valor de i: " + i);

