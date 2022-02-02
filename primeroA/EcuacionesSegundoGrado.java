package primeroA;

import java.util.Scanner;
public class EcuacionesSegundoGrado{
    public static void main(String[] args){

        double x1;
        double x2;
        double parteEnterax1;
        double parteImaginariax1;
        double parteEnterax2;
        double parteImaginariax2;
        
        Scanner sc = new Scanner(System.in);
        System.out.printf("Hola, bienvenido a la calculadora de ecuaciones de segundo grado. por favor, introduzca los valores de la ecuación.\n\n");

        System.out.printf("Introduzca el valor de a: ");
        double a = sc.nextDouble();
        System.out.printf("\nIntroduzca el valor de b: ");
        double b = sc.nextDouble();
        System.out.printf("\nIntroduzca el valor de c: ");
        double c = sc.nextDouble();

        if(a==0){
            if(b==0){
                if (c==0){
                    System.out.println("\nHay infinitas soluciones");
                }
                else{
                    System.out.println("\nNo hay solución posible");
                }
            }
            else{
                x1 = (-c/b);
                System.out.println("\nEl valor de X es: " +x1);
            }
        }
        else{
            if(b==0 && c==0){
                x1=0;
                System.out.println("\nEl valor de X es: " +x1);
                }
            else if(c==0){
                x1 = 0;
                x2 = (-b/a);
                System.out.println("\nEl valor de X1 es: " +x1+ "\nEl valor de X2 es: "+x2);
            }
            else if(b==0){
                x1 = Math.sqrt(-c/a);
                x2 = - Math.sqrt(-c/a);
                System.out.println("\nEl valor de X1 es: " +x1+ "\nEl valor de X2 es: "+x2);
            }
            else{
                if(Math.sqrt(b*b-4*a*c)>=0){
                    x1 = (-b + (Math.sqrt(b*b-4*a*c)))/(2*a);
                    x2 = (-b - (Math.sqrt(b*b-4*a*c)))/(2*a);
                    System.out.println("\nEl valor de X1 es: " +x1+ "\nEl valor de X2 es: "+x2);
                }
                else{
                    parteEnterax1 = (-b/(2*a));
                    parteImaginariax1 = + (Math.sqrt(+4*a*c-b*b))/(2*a);
                    parteEnterax2 = (-b/(2*a));
                    parteImaginariax2 = - (Math.sqrt(+4*a*c-b*b))/(2*a);
                    System.out.println("\nEl valor de X1 es: " +parteEnterax1+" "+parteImaginariax1+" i");
                    System.out.println("El valor de X2 es: " +parteEnterax2+" "+parteImaginariax2+" i");
                }
            }
        }
        sc.close();
    }
}