package primeroA;

import java.util.Scanner;
public class SwitchExample{

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("¿Cuál es tu color preferido?");
        System.out.println("\n1.Amarillo");
        System.out.println("2.Rojo");
        System.out.println("3.Azul");
        System.out.println("4.Verde");
        System.out.println("5.Morado");
        System.out.println("6.Blanco");
        System.out.println("7.Naranja\n");

        do{
        
        System.out.println("\nElige tu color: "); int color = sc.nextInt();
        
        switch(color){
            case 1:
            System.out.print("\nEl mejor color, qué buen gusto!\n");
            break;
            case 2:
            System.out.print("\nBastante básico, pero no una mala elección.\n");
            break;
            case 3:
            System.out.print("\nBasiquísimo.\n");
            break;
            case 4:
            System.out.print("\nMe caes bien.\n");
            break;
            case 5:
            System.out.print("\nEres literalmente una niña emo bajita de 16 años.\n");
            break;
            case 6:
            System.out.print("\nChic@, alegría un poco no?\n");
            break;
            case 7:
            System.out.print("\nTe metes coca.\n");
            break;
            default:
            System.out.print("\nElige un color válido sisplau.\n");
        
        }

        }while(true);
        
    }
}