import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteSMTP {
    public static void main(String[] args) throws UnknownHostException, IOException{
        try{
            //EJERCICIO 7
            System.setProperty ("line.separator","\r\n");
            Socket c = new Socket("smtp.upv.es", 25);
            System.out.println("Conectado");

            PrintWriter salida = new PrintWriter(c.getOutputStream());
            salida.printf("HELO rdc7.redes.upv.es");
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

//ìY Exº|@<+i*ø2*$òâ¹ªâßÌPsGh250 smtp.upv.es Hello vpn36-19.vpns.upv.es [158.42.36.19], pleased to meet you
