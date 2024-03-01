const {zmq, lineaOrdenes, traza, error, adios, conecta} = require('../tsr')
lineaOrdenes("brokerHost brokerPort")
let req = zmq.socket('req')
let id  = "C_"+require('os').hostname()
req.identity = id
conecta(req, brokerHost, brokerPort)

req.send("C_"+require('os').hostname())

function procesaRespuesta(msg) {
        traza('procesaRespuesta','msg',[msg])
        adios([req], `Recibido: ${msg}. Adios`)()
}
req.on('message', procesaRespuesta)
req.on('error', (msg) => {error(`${msg}`)})
process.on('SIGINT', adios([req],"abortado con CTRL-C"))
