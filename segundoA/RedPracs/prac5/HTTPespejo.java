package prac5;
import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPespejo{
    public static void main(String args[]) {
        try{
            ServerSocket ss=new ServerSocket(8080);
            while(true){
            Socket s=ss.accept();
            Scanner recibe = new Scanner(s.getInputStream());
            PrintWriter envia = new PrintWriter(s.getOutputStream(), true);
            
            System.out.println(recibe.nextLine());
            
            envia.print("HTTP/1.0 200 OK \r\n ");
            envia.flush();
            envia.print("Content-Type: text/plain \r\n");
            envia.flush();
            envia.println();
            
            String entrada = "a";
            while(!entrada.equals("")){
                entrada = recibe.nextLine();
                System.out.println(entrada);
            }
            
            System.out.println("Se ha conectado un cliente al servidor.");
            
            s.close();
            }
         }
        catch(IOException e) { System.out.println(e); }
    } 
}

