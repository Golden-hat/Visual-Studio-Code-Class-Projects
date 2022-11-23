package prac5;
import java.net.*;
import java.io.*;
import java.util.*;

public class Echo{
    public static void main(String args[]) {
        try{
            ServerSocket ss=new ServerSocket(7777);
            while(true){
            Socket s=ss.accept(); 
            
            Scanner recibe = new Scanner(s.getInputStream());
            PrintWriter envia = new PrintWriter(s.getOutputStream());
            envia.printf("mensaje a enviar\r\n");
            envia.flush();
            
            System.out.println(recibe.nextLine());
            System.out.println("Se ha conectado un cliente al servidor.");
            
            s.close();
            }
         }
        catch(IOException e) { System.out.println(e); }
    } 
}
