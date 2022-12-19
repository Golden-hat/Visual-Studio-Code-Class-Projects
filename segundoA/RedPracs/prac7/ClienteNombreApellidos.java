package prac7;
import java.net.*;
import java.util.*;

public class ClienteNombreApellidos {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, escriba su nombre y apellidos: ");
        String name = sc.nextLine();

        DatagramPacket dp = new DatagramPacket(name.getBytes(), name.getBytes().length, InetAddress.getByName("localhost"), 7777);
        ds.send(dp);

        sc.close();
        ds.close();
    }
}