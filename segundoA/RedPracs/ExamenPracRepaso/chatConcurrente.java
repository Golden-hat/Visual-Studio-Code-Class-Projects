package ExamenPracRepaso;
import java.io.*;
import java.net.*;
import java.util.*;

public class chatConcurrente extends Thread{
    public Socket id;

    public chatConcurrente(Socket socket){
        this.id = socket;
    }

    public void run(){
        try{
            PrintWriter envio = new PrintWriter(id.getOutputStream(), true);
            Scanner recibo = new Scanner(id.getInputStream());

            envio.println("Cuál es su nombre?");
            String nombre = recibo.nextLine();
            envio.println("\nBienvenido al chat! Escriba sus mensajes a continuación.\n");

            while(recibo.hasNextLine()){
                String s = recibo.nextLine();
                System.out.println(nombre.toUpperCase()+": "+s);
                if(s.toLowerCase().equals("fin")){id.close();}
            }
        }catch(Exception e){System.err.println("Exception: "+e+" happened.");}
    }

    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(7777)){
            while(true){
                Socket s = ss.accept();
                new chatConcurrente(s).start();
            }
        }catch(Exception e){System.err.println("Whoopsie kadoopsie! Something has gone wrong! :(. Exception: "+e);}
    }
}
