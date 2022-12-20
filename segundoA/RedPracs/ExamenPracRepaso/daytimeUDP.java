package ExamenPracRepaso;
import java.net.*;
import java.util.*;

public class daytimeUDP extends Thread{
    public static void main(String[] args) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(7777);
        byte[] receiveDataBuffer = new byte[1024];
        byte[] sendDataBuffer = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(receiveDataBuffer, receiveDataBuffer.length);
    }
}

