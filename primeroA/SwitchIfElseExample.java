package primeroA;

import java.util.Scanner;
class SwitchIfElseExample {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Hola!, por favor introduzca el primer valor a comparar: ");
        double x = sc.nextDouble();
        System.out.println("\nHola!, por favor introduzca el segundo valor a comparar: ");
        double y = sc.nextDouble();

        if (x == y){
            System.out.println("\nEl valor del primer término y el segundo es equivalente");
        }
        else if( x > y){
            System.out.println("\nEl valor del primer término es mayor que el segundo");
        }
        else{
            System.out.println("\nEl valor del segundo término es mayor que el segundo");
        }

        sc.close();
    }    
}

