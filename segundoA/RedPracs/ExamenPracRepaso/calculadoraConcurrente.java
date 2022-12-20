package ExamenPracRepaso;
import java.net.*;
import java.io.*;
import java.util.*;

public class calculadoraConcurrente extends Thread{

    public Socket id;

    public calculadoraConcurrente(Socket socket){
        this.id = socket;
    }

    public void run(){
        try(Scanner recibo = new Scanner(id.getInputStream())){
            while(recibo.hasNextLine()){
                float result = calculate(recibo.nextLine());
                PrintWriter envio = new PrintWriter(id.getOutputStream(), true);
                envio.println(result);
            }
        }
        catch(Exception e){System.err.println("Exception "+e+" happened.");}
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

    public static void main(String[] args) {

        try(ServerSocket ss = new ServerSocket(7777)){
            while(true){
                Socket s = ss.accept();
                new calculadoraConcurrente(s).start();
            }
        }catch(Exception e){}

    }
}