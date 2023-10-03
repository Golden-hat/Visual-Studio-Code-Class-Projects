'use strict'

let val = 5
let valS1 = val + "5";
let valS2 = val - "5";

console.log ("val = " + val)
console.log ("valS1 = " + valS1)
console.log ("valS2 = " + valS2)

/** 
 * 3.2 Razona por qué la resta funciona de forma diferente a la suma.

Porque la suma coerciona el tipo a string, mientras que la resta, a entero.

    3.3 Consulta en Internet información sobre el lenguaje “TypeScript”. Razona los motivos que están
    llevando a su creciente implantación a día de hoy.

TypeScript es exactamente igual que javascript solo que con tipado de variables, lo que reduce el número
de errores a la larga, facilita el debugging y "evita" incongruencias como las vistas en este ejercicio
 * 
 * */