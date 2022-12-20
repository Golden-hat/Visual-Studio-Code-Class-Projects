package prac7;
import java.net.*;

public class ClienteNombreApellidos {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();

        String name = "Yassin Juan Pellicer Lamla";

        DatagramPacket dp = new DatagramPacket(name.getBytes(), name.getBytes().length, InetAddress.getByName("localhost"), 7777);
        ds.send(dp);
        ds.close();
    }
}