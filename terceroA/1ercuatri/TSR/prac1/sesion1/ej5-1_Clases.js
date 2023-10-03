'use strict'

class Animal {
//	nombre;
	constructor (nombre) {
		this.nombre = nombre;
	}
	habla() {}
	nombreAnimal() {return this.nombre}
}

class Perro extends Animal {
	constructor () {
		super ("perro");
	}
	habla() {return "sanxe"}
}

let perro = new Perro();
console.log (perro.nombreAnimal() + " dice " + perro.habla())