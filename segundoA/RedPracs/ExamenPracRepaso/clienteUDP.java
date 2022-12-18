package ExamenPracRepaso;
import java.net.*;
import java.util.*;

public class clienteUDP {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, escriba su datagrama: ");
        String name = sc.nextLine();

        DatagramPacket dp = new DatagramPacket(name.getBytes(), name.getBytes().length, InetAddress.getByName("localhost"), 7777);
        ds.send(dp);
        ds.receive(dp);

        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);

        ds.close();
        sc.close();
    }
}