package primeroA;
import java.util.Scanner;
public class ComparadorNumeroX {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Hola!, por favor, introduzca el primer valor a comparar: ");
        double x = sc.nextDouble();
        System.out.println("\nPor favor, introduzca el segundo valor a comparar: ");
        double y = sc.nextDouble();
        System.out.println("\nIntroduzca el tercer valor a comparar: ");
        double z = sc.nextDouble();

        double m = x;

        if (y > m){
            m = y;
        }
        if (z > m){
            m = z;
        }
        System.out.println("\nEl valor del tercer término es el mayor de entre los 3 (" +m+")");
        sc.close();
    }
}
