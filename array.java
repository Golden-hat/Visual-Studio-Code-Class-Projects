public class array {
    public static void main(String[] args) {
        double a[] = new double[]{1, 1, 2, 3, 4, 5, 0, 7, 54, 9, 0, 11, 12, 13, 14};
        printArr(a);
        System.out.println();
        System.out.println(maximum(a));
        System.out.println();

        int[] b = longestRainingPeriod(a);

        for(int i = 0; i < b.length; i++){
            System.out.print(b[i]);
        }
    }

    public static void swap(double [] a, int j, int k){
        double temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    public static void printArr(double [] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static int maximum(double [] a){
        int pos = 0;
        
        for(int i = 1; i<a.length; i++){
            if(a[i] > a[pos]){
                pos = i;
            }
        }
        return pos;
    }

    public static int[] longestRainingPeriod(double[] x){
        int counter = 0, max_count = 0, pos = -1;

        for (int i = 0; i < x.length; i++){
            if (x[i] > 0){
                if (++counter >= 3){
                    if (counter > max_count){
                        max_count = counter;
                        pos = i - counter + 1;
                    }
                }
            }else{
                counter = 0;
            }
        }

        if (pos < 0){
            return null;
        }else{
            int[] r = new int [2];
            r[0] = pos;
            r[1] = max_count;
            return r;
        } 
    }
}
