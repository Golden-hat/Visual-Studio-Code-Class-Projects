package primeroA;
import java.util.Scanner;
public class ArrayInputJava{   
    public static void main (String Args[]){

        System.out.println("Elija el número de términos que quiere sumar (hasta 50 términos): \n");

        Scanner z = new Scanner(System.in);
        int n = z.nextInt();
        System.out.println("\n");
      
        float[] inputArray = new float[50];
        float sum = 0;

        Scanner i = new Scanner(System.in);

        for(int x = 0; x<n; x++){
            inputArray[x] = i.nextFloat();
            sum = sum+inputArray[x];
        }

        i.close();

        System.out.println("\n");
        System.out.println("La suma de todos los términos que ha introducido es igual a " +sum);
        z.close();
    }
}