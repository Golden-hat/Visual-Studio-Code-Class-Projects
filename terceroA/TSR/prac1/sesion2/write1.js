const fs = require('fs');
fs.writeFile('/tmp/f', 'contenido del nuevo fichero', 'utf8', function (err) {
	if (err) {
 		return console.log(err);
 	}
 	console.log('se ha completado la escritura');
});

// Solo hay una iteración ya que solo hay un evento y una sola llamada