package primeroA;
import java.util.Scanner;
public class ComparadorNumeroMayor3 {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Hola!, por favor, introduzca el primer valor a comparar: ");
        double x = sc.nextDouble();
        System.out.println("\nPor favor, introduzca el segundo valor a comparar: ");
        double y = sc.nextDouble();
        System.out.println("\nIntroduzca el tercer valor a comparar: ");
        double z = sc.nextDouble();

        if ( x == y && x == z){
            System.out.println("\nEl valor del primer término, el segundo y el tercero es equivalente");
        }
        else if( x > y && x > z ){
            System.out.println("\nEl valor del primer término es el mayor de entre los 3 (" +x+")");
        }
        else if( y > x && y > z) {
            System.out.println("\nEl valor del segundo término es el mayor de entre los 3 (" +y+")");
        }
        else{
            System.out.println("\nEl valor del tercer término es el mayor de entre los 3 (" +z+")");
        }
        sc.close();
    }    
}
