import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteEco {
    public static void main(String[] args) throws UnknownHostException, IOException{
        try{
            //ES IMPORTANTE UTILIZAR LA VPN PARA QUE FUNCIONE, Ejercicio 4, 5
            Socket c = new Socket("zoltar.redes.upv.es", 7);
            System.out.println("Conectado");
            PrintWriter salida = new PrintWriter(c.getOutputStream());
            salida.printf("Hola Mundo!\r\n");
            //Ejercicio 6
            salida.flush();

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
