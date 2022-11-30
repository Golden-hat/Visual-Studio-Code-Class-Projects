package prac7;
import java.net.*;

public class DatagramPort{
    public static void main(String[] args) throws SocketException{
        DatagramSocket ds = new DatagramSocket();
        int p = ds.getLocalPort();

        System.out.println(p);

        ds.close();
    }
}