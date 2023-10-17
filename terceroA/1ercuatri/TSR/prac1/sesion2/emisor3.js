//...
const ev = require('events');
const { lstat } = require('fs');
const emitter = new ev.EventEmitter()
const e1='e1', e2='e2'
let inc=0, t

function rand() { // debe devolver valores aleat en rango [2000,5000) (ms)
 	//... // Math.floor(x) devuelve la parte entera del valor x
 	//... // Math.random() devuelve un valor en el rango [0,1)

	let randVal = Math.random();
	randVal = Math.floor(randVal* 3000);
	randVal = randVal + 2000;

	return randVal;
}

function handler (e,n) { // e es el evento, n el valor asociado
 	return (inc) => {
		n += inc;
		console.log(e + " --> "+n)
	} // el oyente recibe un valor (inc)
}

emitter.on(e1, handler(e1,0))
emitter.on(e2, handler(e2,''))

function etapa() {
	emitter.emit(e1, inc)
	emitter.emit(e2, inc)
	// sequence, iteration, generation with param
	inc++;
	console.log("etapa "+inc+" iniciada después de "+t+" ms")
	setTimeout(etapa,t=rand())
}

setTimeout(etapa,t=rand())

/**
 * 	t = 0
	for (let i=0; i<=10; i++) {
	t = t + rand();
	setTimeout(etapa, t);
	}

	Programar todas las etapas con un código como este
	implicaría que necesitamos que el incremento
	se haga en cada etapa internamente.
 */
