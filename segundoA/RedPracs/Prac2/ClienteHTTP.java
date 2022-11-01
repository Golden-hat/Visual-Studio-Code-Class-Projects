import java.io.*;
import java.net.*;
import java.util.Scanner;

class ClienteHTTP{
    public static void main(String[] args) throws UnknownHostException, IOException{
        try{
            System.setProperty ("line.separator","\r\n");
            Socket s = new Socket("www.upv.es", 80);
            System.out.println("Conectadoasdasd");

            PrintWriter salida = new PrintWriter(s.getOutputStream());
            salida.printf("GET / HTTP/1.0\r\n\r\n");
            salida.flush();

            Scanner entrada = new Scanner(s.getInputStream());
            System.out.println(entrada.nextLine());
            s.close();
        }
        catch (UnknownHostException e){
            System.out.println("Host desconocido!");
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println("No se puede conectar!");
            System.out.println(e);
        }
    }
}