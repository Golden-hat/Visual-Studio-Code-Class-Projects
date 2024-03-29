const net = require('net');

function argumentsPassed(){
	string = ""
	for(let i = 2; i < process.argv.length; i++){
		string += process.argv[i]+" ";
	}
	return string;
}
	
string = argumentsPassed()
text = string.split(" ")

proxy_ip = text[0];
new_remote_ip = text[1]
new_remote_port = text[2]

const client = net.connect({proxy_ip}, function() { //connect listener
	console.log('client connected');
	client.write(new_remote_ip+" "+new_remote_port);
})

client.on('data', function(data) {
 	console.log(data.toString());
 	client.end(); //no more data written to the stream
});

client.on('end', function() {
	console.log('client disconnected');
});
