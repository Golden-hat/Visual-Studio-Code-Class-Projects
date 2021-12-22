public class array {

    
    public static void main(String[] args) {
        double a[] = new double[]{1, 1, 2, 3, 4, 5, 0, 7, 54, 9, 0, 11, 12, 13, 14, 15, 16, 16, 723, 634};

        moveAndShiftRight(a, 4);
        printArr(a);
    }

    public static void swap(double [] a, int j, int k){
        double temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    public static void printArr(double [] a){
        System.out.print("{");
        for (int i = 0; i < a.length-1; i++){
            System.out.print(a[i]+", ");
        }
        System.out.print(a[a.length-1]);
        System.out.println("}");
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

    public static int sentinel_search(double[] a, int x){
        a[0] = x;
        int i = a.length - 1;
        while (a[i] != x){
            i--;
        }
        return i==0 ? -1:i;
    }

    public static int[] longestHigherThan3Period(double[] x){
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

    /*
    El método identifica la posición shiftVal del array a[]
    y la pone en frente del array. Es decir, si el array es
    a = {pera, plátano, manzana, higo, uva}, y seleccionamos
    el valor posicion 2, el método retornará:
    a = {pera, plátano, higo, uva, manzana}
    */
    public static void moveAndShiftLeft(double a[], int shiftVal){
        double shift = a[shiftVal];

        for(int i = shiftVal; i < a.length-1; i++){
            a[i] = a[i+1];
        }
        a[a.length-1] = shift;
    }

    /*
    El método identifica la posición shiftVal del array a[]
    y la pone al final del array. Es decir, si el array es
    a = {pera, plátano, manzana, higo, uva}, y seleccionamos
    el valor posicion 2, el método retornará:
    a = {manzana, pera, plátano, higo, uva}
    */
    public static void moveAndShiftRight(double a[], int shiftVal){
        double shift = a[shiftVal];

        for(int i = shiftVal; i > 0; i--){
            a[i] = a[i-1];
        }
        a[0] = shift;
    }
}
