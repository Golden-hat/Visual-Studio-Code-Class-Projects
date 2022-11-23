import java.io.*;
import java.net.*;

class ClienteTCP3{
    public static void main(String[] args) throws UnknownHostException, IOException{
        try{
            Socket s = new Socket("www.upv.es", 80);
            //EJERCICIO 9
            System.out.println(s.getPort());
            System.out.println(s.getInetAddress());
            System.out.println(s.getLocalPort());
            System.out.println(s.getLocalAddress());
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