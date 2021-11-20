public class triangle{
    public static void main(String[] args) {
        int n = 10;
        int o = 30;
        for(int i = 0; i < n; i++){
                line (o+n-i , ' ');
                line (2*i-1, '*');
            System.out.println();
        }
    }
    public static void line (int n, char symbol){
        while (--n >= 0) System.out.print(symbol);
    }
}