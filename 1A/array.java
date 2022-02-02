public class array {

    public static final int maxsize = 10000;
    public static int size = 50;
    public static int Offset = 50;
    public static double[] a = new double[maxsize];

    public static void main(String[] args) {
        addSingleTerm(a, 1);
        addSingleTerm(a, 342);
        addSingleTerm(a, 5642);
        addSingleTerm(a, 2231);
        addSingleTerm(a, 12);
        addSingleTerm(a, 21312);
        addSingleTerm(a, 223);
        printArr(a);

        desplazarDcha(a, 4, 8);
        printArr(a);
    }

    public static void swap(double [] a, int j, int k){
        double temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    public static void printArr(double [] a){
        System.out.print("{");
        for (int i = 0; i < size-1; i++){
            System.out.print(a[i]+", ");
        }
        System.out.print(a[size-1]);
        System.out.println("}");
    }

    public static int maximum(double [] a){
        int pos = 0;
        
        for(int i = 1; i<size; i++){
            if(a[i] > a[pos]){
                pos = i;
            }
        }
        return pos;
    }

    public static int minimum(double [] a){
        int pos = 0;
        
        for(int i = 1; i<size; i++){
            if(a[i] < a[pos]){
                pos = i;
            }
        }
        return pos;
    }

    public static int sentinel_search(double[] a, int x){
        double element = a[0];
        a[0] = x;
        int i = size - 1;
        while (a[i] != x){
            i--;
        }
        a[0] = element;
        return i==0 ? -1:i;
    }

    public static int[] longestHigherThan3Period(double[] x){
        int counter = 0, max_count = 0, pos = -1;

        for (int i = 0; i < size; i++){
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
    public static void moveFrontAndShiftLeft(double a[], int shiftVal){
        double shift = a[shiftVal];

        for(int i = shiftVal; i < size-1; i++){
            a[i] = a[i+1];
        }
        a[size-1] = shift;
    }

    /*
    El método identifica la posición shiftVal del array a[]
    y la pone al final del array. Es decir, si el array es
    a = {pera, plátano, manzana, higo, uva}, y seleccionamos
    el valor posicion 2, el método retornará:
    a = {manzana, pera, plátano, higo, uva}
    */
    public static void moveBackAndShiftRight(double a[], int shiftVal){
        double shift = a[shiftVal];

        for(int i = shiftVal; i > 0; i--){
            a[i] = a[i-1];
        }
        a[0] = shift;
    }

    public static void addMultipleTerm(double a[], double[] b){
        int temporal = size;
        size += b.length;
        int n = 0;

        while (size != temporal){
            a[temporal] = b[n];
            n++;
            temporal++;
        }
    }

    public static void addSingleTerm(double a[], double b){
        int temporal = size;
        size++;

        while (size != temporal){
            a[size-1-Offset] = b;
            temporal++;
        }
    }
    
    public static void desplazarDcha(double[] a, int pos, double add){
        for(int i = size-1; i >= pos; i--){
            a[i] = a[i-1];
        }
        a[pos] = add;
        
    }

    public static void RemoveAndShiftLeft(double[] a, int pos){
        a[pos] = 0;

        for (int i = pos; i < size-1; i++){
            a[i] = a[i+1];
        }
        a[size-1] = 0;
        size--;
    }

    public static void LowerToHigher(double[] a){
        double tmp = 0;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(a[i] < a[j]){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void HigherToLower(double[] a){
        double tmp = 0;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(a[i] > a[j]){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
