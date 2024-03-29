/**
 * Una función callback referencia a una función que se pasa como argumento a otra para
 * que esta última la invoque cuando finalice su ejecución. Vemos un ejemplo.
 */

const fs = require('fs')

fs.writeFileSync('data1.txt',
    'Hello Node.js')
fs.writeFileSync('data2.txt',
    'Hello everybody!')

function callback(err, data) {
    if (err) console.error('---\n' + err.stack)
    else console.log('---\nFile content is:\n' + data.toString())
}

setTimeout(function () { fs.readFile('data1.txt', callback) }, 3000)
fs.readFile('data2.txt', callback)

/**
 * data3.txt se ejecuta mucho más rápido que data2 porque data3.txt no existe. Salta
 * excepción, y te ahorras todos los pasos de tener que leer el fichero, traerlo a memoria...
 */
fs.readFile('data3.txt', callback)

/**
 * Esta es la primera línea de código que se añade a la pila de llamadas. El resto, se añaden a la cola
 * de eventos, ya que readFile es un evento. Recordemos que esta cola no se vacía hasta que la pila de
 * llamadas quede totalmente vacía.
 */
console.log("root(2) =" , Math.sqrt(2))