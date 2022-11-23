import java.io.*;
import java.net.*;

class ClienteTCP1{
    public static void main(String[] args) throws UnknownHostException, IOException{
        try{
            Socket s = new Socket("www.upv.es", 80);
            System.out.println("Conectado!");
            s.close();
        }
        catch (UnknownHostException e){
            System.out.println("Host desconocido!");
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println("No se puede conectar!");
            System.out.println(e);
        }
    }
}