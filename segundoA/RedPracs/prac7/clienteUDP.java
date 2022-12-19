package prac7;
import java.net.*;

public class clienteUDP {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();
        String name = "josecarlos";

        DatagramPacket dp = new DatagramPacket(name.getBytes(), name.getBytes().length, InetAddress.getByName("localhost"), 7777);
        ds.send(dp);
        ds.receive(dp);

        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);

        ds.close();
    }
}