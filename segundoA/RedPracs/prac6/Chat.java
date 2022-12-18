package prac6;
import java.net.*;
import java.util.Scanner;
import java.io.*;


public class Chat extends Thread{
    
    Socket id;
    public Chat (Socket s) {id=s;}

    public void run(){
        try{
            Scanner recibe = new Scanner(id.getInputStream());
            while(recibe.hasNextLine()){
                System.out.println(recibe.nextLine());
            }
        }
        catch(Exception e){System.out.println("Error en el run(): "+e);}
    }

    public static void main(String[] args) throws IOException{
        try (ServerSocket ss = new ServerSocket(7777)) {
            Socket s = ss.accept();
            new Chat(s).start();

            PrintWriter envia = new PrintWriter(s.getOutputStream(), true);
            Scanner teclado = new Scanner(System.in);
            String l = "";
            
            while(true){
                l = teclado.nextLine();
                envia.println(l);
                if(l.equalsIgnoreCase("FIN")) break;
            }
            s.close();
            teclado.close();
        }
    }
}
