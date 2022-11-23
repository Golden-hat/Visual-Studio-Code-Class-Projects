package prac6;
import java.net.*;
import java.util.Scanner;
import java.io.*;


public class SCTCP extends Thread{
    
    Socket id;
    public SCTCP (Socket s) {id=s;}

    public void run(){
        try{
            Scanner recibe = new Scanner(id.getInputStream());
            PrintWriter envia = new PrintWriter(id.getOutputStream(), true);
            
            String texto = recibe.nextLine();

            while(!texto.equalsIgnoreCase("FIN")){

                envia.println(texto);
                texto = recibe.nextLine();
            }
            id.close();
        }
        catch(Exception e){System.out.println("Error en el run(): "+e);}
    }

    public static void main(String[] args) throws IOException{
        try (ServerSocket ss = new ServerSocket(7777)) {
            while(true){
                Socket s = ss.accept();
                SCTCP t = new SCTCP(s);
                t.start();
            }
        }
    }
}
