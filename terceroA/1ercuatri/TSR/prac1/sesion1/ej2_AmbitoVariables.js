'use strict';

let global1_let = "variable global 1"
var global2_var = "variable global 2"
var global3 = "variable global 3"

function f1 (arg) {
	global1_let = arg;    // Puedo también modificar las otras globales?
	console.log ("global1= " + global1_let)
	console.log ("global2= " + global2_var)
	console.log ("global3= " + global3)
}

function f2 () {

	let local1_let = 5;

	for (let let_i=0; let_i<5; let_i++) {
		console.log ("let_i: " + let_i)
	}

	for (var var_i=0; var_i<5; var_i++) {
		console.log ("var_i: " + var_i)
	}

	console.log ("fin --> var_i=" + var_i)

	// local_let = var_i - 5; // Me equivoco al teclear "local_let1"
	local1_let = var_i - 5;
	console.log ("local1_let=" + local1_let)
	console.log ("local_let=" + local1_let)

}

f1 ("nuevo valor")
f2 ();

/**
 *  Cuestión 1. Observa que el programa modifica el valor de una variable global dentro de la función
	“f1”. ¿Podemos modificar el valor de las otras variables globales? ¿Qué diferencias hay entre declarar
	variables globales con “let” y con “var”?

las variables declaradas con let solo están disponibles para el scope del bloque en el que se declaran.
Por el contrario, las variables declaradas con var están disponibles para todo el scope de la función
en la que aparecen, sin importar el nivel de nesting en el que aparezcan (es decir, la variable var x,
dentro de un if, por ejemplo... será accesible fuera de ese if) (si no están declaradas dentro de una
función se comportan como variables globales). Esto es debido al HOISTING, y al hecho de que todas
las funciones necesitan tener una closure determinada para ser interpretadas.

Las variables globales con let no se pueden redeclarar. Si ya existe un let global1_let, no podrá
existir otra variable con el mismo nombre.

	Observa que en la línea 24 se imprime el valor de la variable “var_i”. ¿podemos imprimir
	el valor de la variable “let_i” ? Prueba a hacerlo y razona lo que observas. Razona qué diferencias hay
	entre usar “let” y usar “var”.

No. no podemos ya que no pertenece al scope del resto de la función (está restringido al bucle for).

	Cuestión 3. Este programa no utiliza la directiva “use strict” al comienzo del programa. Añádela y
	prueba a ejecutar de nuevo el programa. ¿Qué observas? Explica para qué sirve la directiva “use strict”.

Use strict sirve, para entre otras cosas, forzar la inicialización de variables declaradas.

	Cuestión 4. Modifica el programa para que funcione correctamente usando la directiva “use strict”.
	Corrige el error que ha cometido el programador por referenciar equivocadamente la variable
	“local1_let”. Razona qué ventajas tiene para el programador el uso de la directiva “use strict”.

 */