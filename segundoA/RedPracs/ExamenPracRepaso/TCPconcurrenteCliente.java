package ExamenPracRepaso;
import java.net.*;
import java.io.*;
import java.util.*;

public class TCPconcurrenteCliente extends Thread{
    public Socket id;

    public TCPconcurrenteCliente(Socket s){
        id = s;
    }

    public static void main(String[] args) throws UnknownHostException, IOException{
        //se crea un servidor que recibe la info de los hilos echo.
        try(ServerSocket ss = new ServerSocket(7777)){
            while(true){
                Socket s = ss.accept();
                /*
                 * una vez aceptado el socket, se lanza un hilo
                 * echo que se comunica con el servidor
                 */
                new TCPconcurrenteCliente(s).start();
            }
        }
    }    

    public void run(){
        try{
            PrintWriter salida = new PrintWriter(id.getOutputStream() ,true);
            Scanner entrada = new Scanner(id.getInputStream());
            String s = entrada.nextLine();
            //cada servidor evalúa independientemente si el input es FIN
            while(!s.equalsIgnoreCase("FIN")){
                salida.println(s);
                s = entrada.nextLine();
            }
            id.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
