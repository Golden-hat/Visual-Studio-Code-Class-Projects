package primeroA;

public class numeroE {
    public static void main(String[] args) {
        System.out.println(exp(1, 500));
    }
    
    public static double exp(double x, int n){
        double num = 1;
        double den = 1;
        double s = num/den;

        for(int i = 1; i<=n; i++){
            num *= x;
            den *= i;
            s += num/den;
        }
        return s;
    }
}
