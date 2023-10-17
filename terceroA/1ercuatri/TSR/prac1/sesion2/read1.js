const fs = require('fs');

fs.readFile('./texto.txt', 'utf8', function (err,data) {
 	if (err) {
 		return console.log(err);
 	}
 	console.log(data);
});

// Solo hay una iteración ya que solo hay un evento y una sola llamada