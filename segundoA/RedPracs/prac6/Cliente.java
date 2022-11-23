package prac6;
import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente extends Thread {
        
    Socket id;
    public Cliente (Socket s){ id = s; }

    public void run(){
        try{
            Scanner entrada = new Scanner(id.getInputStream());
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException{

        try (ServerSocket ss = new ServerSocket(7777)) {

            String l = "";

            while(true){
                Socket s = ss.accept();
                new Cliente(s).start();

                PrintWriter salida = new PrintWriter(s.getOutputStream());
                try (Scanner entradaTeclado = new Scanner(System.in)) {
                    l = entradaTeclado.nextLine();
                }

                salida.println(l);
                if(l.equalsIgnoreCase("quit")) break;
            }
        }
    }
}
