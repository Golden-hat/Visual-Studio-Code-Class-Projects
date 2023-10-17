const fs = require('fs');
function readFilePromise(){
	return new Promise((resolve, reject) =>{
		fs.readFile('./texto.txt', 'utf8', function (err,data) {
		 	if (err) {
		 		return console.log(err);
		 	}
		 	console.log(data);
		});
	})
}

readFilePromise().then(console.error, console.log) 

// Solo hay una iteración ya que solo hay un evento y una sola llamada