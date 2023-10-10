function main(y) {
	var traza = "inicio";
	return f(y);

	function f(y) {
		var x = 100 + y;

		console.log("\ttraza: ", traza);

		function g0() {
			console.log("hola desde g0")
			traza += "-g0";
			x++;
			console.log("g0: incremento de x:  " + x);
			return f(++y); //ignoro el valor de retorno
			/**
			 * el return de f(++y) no se hace, ya que f(++y) no retorna una función
			 */
		}

		function g1() {	
			console.log("hola desde g1")
			traza += "-g1";
			y++;
			console.log("g1: incremento de y:  " + y);
			return f(y);
		}		
		
		return (x % 2) ? g0 : g1;
	}
}

var func = main(-100);
for (let i = 0; i < 10; i++) {
	func = func();
}

