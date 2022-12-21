package ExamenPracRepaso;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class serverUDPcalculadora {
    public static void main(String[] args) throws Exception{
        byte[] message = new byte[1000];
        DatagramSocket servidor = new DatagramSocket(7777);
        DatagramPacket paquete = new DatagramPacket(message, 1000);

        while(message.length != 0){
            servidor.receive(paquete);
            String res = new String(paquete.getData(), 0, paquete.getLength());
            String s = calculate(res)+"\n";
    
            paquete.setData(s.getBytes());
            paquete.setLength(s.getBytes().length);
            servidor.send(paquete);
        }
        servidor.close();
    }

    public static float calculate(String s){
        float[] ret = new float[2];

        int i = 0;
        while(i < s.length()){
            switch(s.charAt(i)){
            case '/':
                ret[0] = Float.parseFloat(s.substring(0, i));
                ret[1] = Float.parseFloat(s.substring(i+1, s.length()));
                return (ret[0] / ret[1]);
            case '*':
                ret[0] = Float.parseFloat(s.substring(0, i));
                ret[1] = Float.parseFloat(s.substring(i+1, s.length()));
                return (ret[0] * ret[1]);
            case '+':
                ret[0] = Float.parseFloat(s.substring(0, i));
                ret[1] = Float.parseFloat(s.substring(i+1, s.length()));
                return (ret[0] + ret[1]);
            case '-':
                ret[0] = Float.parseFloat(s.substring(0, i));
                ret[1] = Float.parseFloat(s.substring(i+1, s.length()));
                return (ret[0] - ret[1]);
            case '%':
                ret[0] = Float.parseFloat(s.substring(0, i));
                ret[1] = Float.parseFloat(s.substring(i+1, s.length()));
                return (ret[0] % ret[1]);
            }
            i++;
        }
        return -1;
    }
}
