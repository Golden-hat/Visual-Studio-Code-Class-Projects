package primeroA;

public class PolygonalNumbers{
    public static void main(String[] args) {
        check(15, 3);
    }

    public static boolean check (int k, int s){
        int n = 1;
        int r;
        do{
            r = n*((s-2)*n-(s-4))/2;
            n++;
        }while(r < k);

        return k==r;
    }
}