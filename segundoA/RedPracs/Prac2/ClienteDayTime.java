import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteDayTime {
    public static void main(String[] args) throws UnknownHostException, IOException{
        try{
            //ES IMPORTANTE UTILIZAR LA VPN PARA QUE FUNCIONE
            Socket c = new Socket("zoltar.redes.upv.es", 13);
            Scanner entrada = new Scanner(c.getInputStream());
            System.out.println(entrada.nextLine());
            c.close();
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
