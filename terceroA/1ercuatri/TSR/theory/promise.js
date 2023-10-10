/**
 * Se puede modelar la ejecución asíncrona utilizando promesas en vez de callbacks. Las promesas
 * representan un valor futuro sobre el que podemos asociar operaciones y gestionar errores. Puede
 * estar en uno de los siguientes estados:
 *      -   Pendiente -> es el estado inicial. La operación no ha concluido todavía.
 *      -   Resuelta -> la operación ha concluido y podemos acceder al resultado.
 *          +   Rechazada -> se termina con error. Se acompaña razón.
 *          +   Satisfecha -> se termina con éxito. Se acompaña valor.
 * 
 * Las promesas se construyen mediante el constructor Promise() -> 
 *      Promise((resolutionFunc, rejectionFunc) => {...})
 */

const fs = require('fs')

function readFilePromise(filename) {
    return new Promise((resolve, reject) => {
        fs.readFile(filename, (err, data) => {
            if (err) reject(err + '')
            else resolve(data + '')
        })
    })
}

readFilePromise("promise.js").then(console.log, console.error)
readFilePromise("doesntExist.js").then(console.log, console.error)

/**
 * then()-> permite especificar la gestión a realizar en la resolución de la promesa.
 * catch()-> perimte especificar la gestión a realizar en el rechazo de la promesa.
 * 
 * tanto then como catch devuelven promesas, por lo que es fácil encadenarlas.
 * 
 * all(promiseArray)-> se satisface cuando todas las promesas se han resuelto correctamente. Se
 * rechaza cuando al menos 1 haya sido rechazada.
 * any(promiseArray)-> se satisface cuando 1 promesa se ha resuelto correctamente. Se rechaza cuando
 * todas las promesas hayan sido procesadas.
 * 
 * async-> precede la declaración de una función e indica que retorna una promesa. Retornar valor = satisf.
 * await-> precede la invocación de una función que devuelve una promesa y espera a su resolución. Esta
 * keyword solo puede usarse dentro de funciones asíncronas.
 */

async function readTwoFiles() {
    try {
        console.log(await readFilePromise("readfile.js"))
        console.log(await readFilePromise("doesntExist.js"))
    } catch (err) {
        console.error(err + '')
    }
}

readTwoFiles()

//Or.. We may use catch() here, instead of try/catch in readTwoFiles().
// readTwoFiles().catch( console.error )

