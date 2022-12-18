package prac6;
import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente extends Thread {
        
    Socket id;
    public Cliente (Socket s){ id = s; }

    public void run(){
        try{
            PrintWriter salida = new PrintWriter(id.getOutputStream() ,true);
            Scanner entrada = new Scanner(id.getInputStream());
            String s = entrada.nextLine();
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
    
    public static void main(String[] args) throws UnknownHostException, IOException{

        try (ServerSocket ss = new ServerSocket(7777)){
            while(true){
                Socket s = ss.accept();
                new Cliente(s).start();
            }
        }
    }
}
