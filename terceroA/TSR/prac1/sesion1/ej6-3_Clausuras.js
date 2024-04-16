
// Clausuras de variables y funciones.

function gen (y) {
	var x = 100;
	function inner (){
		x++;
		console.log("incremento de x:  " + x);
		return x;
	}
	return function(){
		y++;
		console.log("y: " + y);
		console.log("y + inner(): ",y + inner());
		return y;
	}

}

let func = gen(-100);
func();
func();
func();
/**
	Cuestión 1. ¿Cuál es la clausura que retorna la función generadora? Detalla las variables, argumentos y
	funciones que forman parte de la clausura

La clausura retornada utiliza las variables x, y y la función inner.
 */