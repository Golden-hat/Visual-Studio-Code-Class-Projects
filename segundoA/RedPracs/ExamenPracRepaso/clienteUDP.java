package ExamenPracRepaso;
import java.net.*;
import java.util.*;

public class clienteUDP {
    public static void main(String[] args) throws Exception{
        //Datagram socket ds crea un socket de datagramas en cualquier puerto disponible del PC
        DatagramSocket ds = new DatagramSocket();

        /*
         * Se utiliza un escaner para recibir el input del usuario.
         * Este input pasa a una string, la cual debe pasarse a bytes...
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, escriba su datagrama: ");
        String name = sc.nextLine();

        /* Datagram packet con 4 parámetros crea un datagrama que enviar a través del
         * socket abierto por datagram socket, HACIA EL PUERTO ESTIPULADO.
         * 
         * send = enviar datos del socket cliente hacia el servidor marcado por dp (7777)
         * receive = recibir datos del servidor marcado por dp (7777) hacia el socket cliente
         */
        DatagramPacket dp = new DatagramPacket(name.getBytes(), name.getBytes().length, InetAddress.getByName("localhost"), 7777);
        ds.send(dp);
        ds.receive(dp);

        //los mensajes recibidos se procesan como un array de bytes, los cuales deben ser desencriptados a strings.
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);

        ds.close();
        sc.close();
    }
}