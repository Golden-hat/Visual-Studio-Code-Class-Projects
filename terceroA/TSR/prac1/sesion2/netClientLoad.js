const net = require('net');

function argumentsPassed(){
	string = ""
	for(let i = 2; i < process.argv.length; i++){
		string += process.argv[i]+" ";
	}
	return string;
}

const client = net.connect({port:8005}, function() { //connect listener
	console.log('client connected');
	client.write(argumentsPassed());
});

client.on('data', function(data) {
 	console.log(data.toString());
 	client.end(); //no more data written to the stream
});

client.on('end', function() {
	console.log('client disconnected');
});
