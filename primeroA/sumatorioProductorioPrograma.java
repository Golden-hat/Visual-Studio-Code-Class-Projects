package primeroA;

import java.util.Scanner;
public class sumatorioProductorioPrograma{
    public static void main(String[] args) {
        double finresult = 0;

        int n = 6;
        int k = 1; 
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecciona tu operación: ");
        int selection = sc.nextInt();
        
        switch (selection){
            case 1:
            while(k <= n){
                finresult += (double) 1/(k);
                k++;
            }
            break;
            case 2:
            while(k <= n){
                finresult += (double) (k);
                k++;
            }
            break;
            case 3:
            while(k <= n){
                finresult += (double) 1/(k*k);
                k++;
            }
            break;
            case 4:
            while(k <= n){
                finresult += (double) (k)*(k);
                k++;
            }
            break;
            case 5:
            k = 0;
            while(k <= n){
                double powProd = 2;
                if(k == 0){
                    powProd = 1;
                }else{
                    for(int x = 1; x < k; x++){
                        powProd *= 2;
                    }
                }
                finresult += (double) powProd;
                k++;
            }
            break;
            case 6:
            while(k <= n){
                double powProd = 2;
                for(int x = 1; x < k; x++){
                    powProd *= 2;
                }
                finresult += (double) 1/powProd;
                k++;
            }
            break;
            case 7:
            finresult = 1;
            while(k <= n){
                finresult *= (double) (k);
                k++;
            }
            break;
        }        
        System.out.println(finresult);
        sc.close();
    }
}