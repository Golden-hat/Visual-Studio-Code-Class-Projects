package primeroA;

import java.util.Scanner;
public class InputSelfSphere{
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        double r;
        System.out.println("Por favor, introduzca el valor del radio de su círculo: ");
        r = sc.nextDouble();

        double volumen = 0;
        double area = 0;

        volumen = 4*Math.PI*r*r;
        System.out.printf("El valor del volumen de la esfera es: %f", volumen);
        area = (4/3.0)*Math.PI*r*r*r;
        System.out.printf("\nEl valor del área de la esfera es: %f\n", area);

        sc.close();
    }

}