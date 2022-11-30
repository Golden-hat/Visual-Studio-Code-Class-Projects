package prac7;
import java.net.*;
import java.util.Scanner;

public class dnslookup{
    public static void main(String[] args){
        System.out.print("Por favor, introduzca el nombre de su pagina web: ");
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();

        sc.close();
        try{
            System.out.println(InetAddress.getByName(ip).toString());
        }
        catch(Exception e){
            System.err.println("Ha habido un error con su input");
        }
    }
}