package primeroB.inheritance.personas;
import java.util.Scanner;

public class lanzadera{
    
    public static void main(String[] args){
        
        int age = 0;
        int student = 0;
        int failed = 0;

        System.out.println("Hello! Introduce your age please:");
        boolean isOk = false;
        do{
            try{
                Scanner sc = new Scanner(System.in);
                age = sc.nextInt();
                isOk = true;
            }catch (Exception e){
                System.out.println("Please, introduce NUMERIC characters only");
            }

        }while(!isOk);

        Scanner nameScan = new Scanner(System.in);
        System.out.println("Now, introduce your name please:");
        String name = nameScan.nextLine();

        System.out.println("Are you a student?\n1.Yes, 2.No");
        
        isOk = false;
        do{
            try{
                Scanner sc = new Scanner(System.in);
                student = sc.nextInt();
                isOk = true;
            }catch (Exception e){
                System.out.println("Please, introduce NUMERIC characters only");
            }

        }while(!isOk);

        if(student == 1){
            System.out.println("How many subjects have you failed?");
            do{
                isOk = false;
                try{
                    Scanner fail = new Scanner(System.in);
                    failed = fail.nextInt();
                    isOk = true;
                }catch (Exception e){
                    System.out.println("Please, introduce NUMERIC characters only");
                }
    
            }while(!isOk);

            claseEstudiante p = new claseEstudiante(age, name, failed);
            System.out.println(p);
        }
        else{
            clasePersonas n = new clasePersonas(age, name);
            System.out.println(n);
        }
    }
}
