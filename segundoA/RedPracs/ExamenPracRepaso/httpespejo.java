package ExamenPracRepaso;
import java.net.*;
import java.io.*;
import java.util.*;

public class httpespejo{
    public static void main(String args[]) {
        try (ServerSocket ss = new ServerSocket(8080)) {
            while(true){
                Socket s = ss.accept();
                /*
                 * Se acepta el socket del cliente
                 * recibe = info enviada por el cliente al server, Scanner(... inputStream)
                 * envia = info enviada por el server al cliente, Scanner(... outputStream)
                 */
                Scanner recibe = new Scanner(s.getInputStream());
                PrintWriter envia = new PrintWriter(s.getOutputStream(), true);
                
                /*
                 * Estas cabeceras son CRUCIALES para el funcionamiento de la página
                 * envia.print("HTTP/1.0 200 OK \r \n");
                 * envia.print("Content-Type: text/plain \r \n");
                 * 
                 * Esto se le envía a la página para "establecer sus parámetros".
                 * Sin estos, la página salta con un error.
                 */
                envia.print("HTTP/1.0 200 OK \r \n");
                envia.print("Content-Type: text/plain \r \n");
                envia.println("\r\n");
                
                /*
                 * Con este bucle, se copia toda la info de la página hasta que se encuentra una
                 * línea sin rellenar. Es importante ver que entrada es un string al que, con cada
                 * iteración del bucle se le añade la línea escaneada más \r\n
                 */
                String entrada = "";
                while(recibe.hasNextLine()){
                    String c = recibe.nextLine();
                    System.out.println(c);
                    entrada += c + "\r\n";
                    if(c.length() == 0)break;
                }

                envia.printf(entrada);
                s.close();
            }
        }catch(IOException e) { System.out.println(e); }
    } 
}