package primeroB.inheritance.personas;
import java.util.Scanner;

public class lanzadera{

    public static Scanner sc = new Scanner(System.in);
    public static Scanner nameScan = new Scanner(System.in);
    public static Scanner fail = new Scanner(System.in);


    public static void main(String[] args){
        
        int age = 0;
        int student = 0;
        int failed = 0;

        System.out.println("Hello! Introduce your age please:");
        boolean isOk = false;
        do{
            try{
                age = sc.nextInt();
                if (age < 0){
                    Exception e = new Exception("InputMismatchException: values can't be less than zero");
                    throw e;
                }
                isOk = true;
            }catch (Exception e){
                System.out.println("The exception «"+e+"» has occurred. "+"Please, introduce VALID entries only.");
                sc.nextLine();
            }

        }while(!isOk);

        System.out.println("Now, introduce your name please:");
        String name = nameScan.nextLine();

        System.out.println("Are you a student?\n1.Yes, 2.No");
        
        isOk = false;
        do{
            try{
                student = sc.nextInt();
                isOk = true;
            }catch (Exception e){
                System.out.println("Please, introduce NUMERIC characters only");
                sc.nextLine();
            }

        }while(!isOk);

        if(student == 1){
            System.out.println("How many subjects have you failed?");
            do{
                isOk = false;
                try{
                    failed = fail.nextInt();
                    isOk = true;
                }catch (Exception e){
                    System.out.println("Please, introduce NUMERIC characters only");
                    fail.nextLine();
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
