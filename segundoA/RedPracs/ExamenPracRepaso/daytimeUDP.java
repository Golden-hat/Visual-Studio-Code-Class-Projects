package ExamenPracRepaso;
import java.net.*;
import java.util.*;

public class daytimeUDP extends Thread{
    public static void main(String[] args) throws Exception{
        byte[] buffer = new byte[1000];
        DatagramSocket ds = new DatagramSocket(7777);
        DatagramPacket p = new DatagramPacket(buffer, 1000);
        ds.receive(p);
        Date now = new Date();
        String now_string = now.toString() + "\r+\n";

        p.setData(now_string.getBytes());
        p.setLength(now_string.getBytes().length);
        ds.send(p);
        ds.close();
    }
}



