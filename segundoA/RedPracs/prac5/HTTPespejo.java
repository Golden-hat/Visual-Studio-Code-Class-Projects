package prac5;
import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPespejo{
    public static void main(String args[]) {
        try (ServerSocket ss = new ServerSocket(8080)) {
            while(true){
                Socket s = ss.accept();
                Scanner recibe = new Scanner(s.getInputStream());
                PrintWriter envia = new PrintWriter(s.getOutputStream(), true);
                
                System.out.println(recibe.nextLine());
                
                String entrada = "";
                while(recibe.hasNextLine()){
                    String c = recibe.nextLine();
                    entrada += c + "\r\n";
                    if(c.length() == 0)break;
                }                                
                envia.print("HTTP/1.0 200 OK \r \n");
                envia.print("Content-Type: text/plain \r \n");
                envia.println("\r\n");
                envia.printf(entrada);
                s.close();
            }
        }catch(IOException e) { System.out.println(e); }
    } 
}

