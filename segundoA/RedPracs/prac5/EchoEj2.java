package prac5;
import java.net.*;
import java.io.*;
import java.util.*;

public class EchoEj2{
    public static void main(String args[]) {
        try (ServerSocket ss = new ServerSocket(7777)) {
            while(true){
            Socket s=ss.accept();
            
            System.out.println("Local address del Socket: "+s.getLocalAddress());
            System.out.println("Local port del Socket: "+s.getLocalPort());
            System.out.println("Inet address del Socket: "+s.getInetAddress());
            System.out.println("Port del Socket: "+s.getPort());
            System.out.println("Inet address del Server Socket: "+ss.getInetAddress());
            System.out.println("Local port del Server Socket:   "+ss.getLocalPort());
            
            Scanner recibe = new Scanner(s.getInputStream());
            PrintWriter envia = new PrintWriter(s.getOutputStream(), true);
            envia.println(recibe.nextLine());
            
            System.out.println("Se ha conectado un cliente al servidor.");
            
            s.close();
            }
        }catch(IOException e) { System.out.println(e); }
    } 
}
