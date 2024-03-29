const net = require('net');
const LOCAL_IP = '127.0.0.1';

//const REMOTE_IP="cdt.gva.es";
//const REMOTE_IP="apache.rediris.es"

const REMOTE_PORT=80
//const REMOTE_IP = '158.42.4.23'; // www.upv.es

function argumentsPassed(){
	string = ""
	for(let i = 2; i < process.argv.length; i++){
		string += process.argv[i]+" ";
	}
	return string;
}
	
string = argumentsPassed()
text = string.split(" ")

const server = net.createServer(function (socket) {	
 	const serviceSocket = new net.Socket();
 	serviceSocket.connect(parseInt(REMOTE_PORT), text[1], function () {
 		socket.on('data', function (msg) {
 			console.log (msg + "")
 			serviceSocket.write(msg);
 		});
 		serviceSocket.on('data', function (data) {
 			socket.write(data);
 		});
	});
}).listen(text[0], LOCAL_IP);

console.log("TCP server accepting connection on port: " + text[0]);