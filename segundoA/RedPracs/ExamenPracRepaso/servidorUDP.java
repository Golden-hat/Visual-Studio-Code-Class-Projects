package ExamenPracRepaso;
import java.io.*;
import java.net.*;

public class servidorUDP {
    public static void main(String[] args) throws IOException {
        try(DatagramSocket s = new DatagramSocket(7777)){        
            DatagramPacket p = new DatagramPacket(new byte[512], 512);
            while(true){
                s.receive(p); // se bloquea hasta que recibe un datagrama
                s.send(p);
            }
        }
    }
}
