package prac7;
import java.net.*;
import java.util.*;

public class daytimeUDP extends Thread{
    public static void main(String[] args) throws Exception{

        byte[] buffer = new byte[1000];
        DatagramSocket ds = new DatagramSocket(7777);
        DatagramPacket p = new DatagramPacket(buffer, 1000);

        System.out.println("Esperando paquete.");
        ds.receive(p);
        System.out.println("Paquete recibido.");
        System.out.println("Enviando respuesta.");

        Date now = new Date();
        String now_string = now.toString() + "\r+\n";
        System.out.println(now_string);
        
        p.setData(now_string.getBytes());
        p.setLength(now_string.getBytes().length);
        ds.send(p);
        System.out.println("Respuesta enviada");
        ds.close();
    }
}
