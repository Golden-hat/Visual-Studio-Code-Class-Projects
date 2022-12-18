package ExamenPracRepaso;
import java.net.*;
import java.io.*;
import java.util.*;

public class servidorTCPSecuencialEcho {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(7777);){
            //ServerSocket es el socket del servidor que queremos crear, el cual está ubicado en el puerto 7777
            while(true){
                //Accept acepta la llegada del socket que quiera conectarse con el servidor.
                Socket s = ss.accept();
                //El print es necesario para el autoflush. En caso contrario, no se envía.
                /* Scanner = información escrita al momento por el cliente
                 * PrintWriter(s.getInputStream() = para recibir el input del cliente)
                 * PrintWriter(s.getOutputStream() = para enviarle input al socket)
                 * getOutputStream() y getInputStream() son métodos pertenecientes a la clase Socket.
                 */
                Scanner entrada = new Scanner (s.getInputStream());
                PrintWriter salida = new PrintWriter(s.getOutputStream(), true);

                System.out.println("Se ha conectado un cliente al servidor.");
                salida.println(entrada.nextLine());

                s.close();
            }
        }
        catch(IOException e){System.err.println(e);}
    }
}
