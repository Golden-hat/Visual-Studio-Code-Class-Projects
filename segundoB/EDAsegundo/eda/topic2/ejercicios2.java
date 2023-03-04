package topic2;

public class ejercicios2{
    public static void main(String[] args){
        Integer[] c = {-5, -4, -3, -2, -1, 1, 2, 3, 4};
        Integer[] d = {0,1,5,7,19,52};
        Integer[] mergeS = {0,1,5,7,19,52,2,3,6,3,4,7,345,678,24523};

        int[] a = {-5, -4, -3, -2, -1, 1, 2, 3, 4};
        int[] b = {33,10,8,1532,11,9235,25,56,12345,7456,2,45,26,47356,236,4768,45,-5634,-37};

        System.out.println(arrayIntegersCurveLinear(a));
        System.out.println(arrayIntegersCurveLog(a));
        System.out.println(concaveCurve(b));
        printArr(b);
        printArr(mergeSortTwo(b));
        printArr(b);
        printArr(mergeS);
    }
    
    //the argument must be a monotonically increasing curve
    public static int arrayIntegersCurveLinear(int[] a){
        return arrayIntegersCurveLinear(a, 0, a.length-1);
    }
        
    public static int arrayIntegersCurveLinear(int[] a, int begin, int end){
        if(begin <= end){
            if(a[begin] > 0){return begin;}
            else{
                begin = begin + 1;
                return arrayIntegersCurveLinear(a, begin, end);
            }
        }
        return -1;
    }
    
    public static int arrayIntegersCurveLog(int[] v){
        return arrayIntegersCurveLog(v, 0, v.length-1);
    }
    
    private static int arrayIntegersCurveLog(int[] v, int i, int j){
        int m = (i + j)/2;
        if(v[m] <= 0){
            if(v[m+1] > 0) return m + 1;
            return arrayIntegersCurveLog(v, m+1, j);
        }
        else{
            return arrayIntegersCurveLog(v, i, m-1);
        }
    }

    //the argument must be a concave curve
    public static int concaveCurve(int[] v){
        return concaveCurve(v, 0, v.length-1);
    }

    private static int concaveCurve(int[] v, int begin, int end){
        int m = (begin + end)/2;
        if(v[m-1] > v[m] && v[m] < v[m+1]){
            return m;
        }
        else{
            if(v[m-1] < v[m+1]){
                return concaveCurve(v, 0, m);
            }
            return concaveCurve(v, m, end);
        }
    }

    /* MERGE SORT WITH INTEGER ARRAYS */

    public static void mergeSort(int[] a){
        mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(int[] a, int ini, int fin){
        int mid = (ini+fin)/2;
        if(ini < fin){
            mergeSort(a, ini, mid);
            mergeSort(a, mid+1, fin);
            merge(a, ini, mid, fin);
        }
        else{
            return;
        }
    }

    private static void merge(int[] a, int ini, int mid, int fin){
        int[] aux = new int[fin-ini+1];
        int i = ini, j = mid+1, k = 0;
        while(i <= mid && j <= fin){
            if(a[i] < a[j]){
                aux[k++] = a[i++];
            }
            else{
                aux[k++] = a[j++];
            }
        }
        for(int r = i; r <= mid; r++){aux[k++] = a[r];}
        for(int r = j; r <= fin; r++){aux[k++] = a[r];}

        k = 0;
        for(i = ini; i <= fin; i++){
            a[i] = aux[k];
            k++;
        }
    }

    public static int[] mergeSortTwo(int[] a){
        return mergeSortTwo(a, 0, a.length-1);
    }

    private static int[] mergeSortTwo(int[] a, int ini, int fin){
        int mid = (ini+fin)/2;
        if(ini < fin){
            mergeSortTwo(a, ini, mid);
            mergeSortTwo(a, mid+1, fin);
            mergeTwo(a, a);
        }
        return a;
    }

    private static int[] mergeTwo(int[] a, int[] b){
        int[] aux = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                aux[k++] = a[i++];
            }
            else{
                aux[k++] = b[j++];
            }
        }
        for(int r = i; r < a.length; r++){aux[k++] = a[r];}
        for(int r = j; r < b.length; r++){aux[k++] = b[r];}
        return aux;
    }

    /* MERGE SORT WITH GENERIC ARRAYS */

    /* Given 2 sorted arrays in ascending order, this methods merges them in order */
    public static <E extends Comparable<E>> E[] merge(E[] a, E[] b){
        E[] res = (E[]) new Comparable[a.length + b.length];
        
        // Esta primera parte se encarga de meter los numeros en orden ascendente de cada array
        // hasta que alguno de los dos se extenúe.
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) < 0) res[k++] = a[i++];
            else res[k++] = b[j++];
        }
        // Esta segunda parte completa con los números faltantes del array no extenuado.
        for (int r = i; r < a.length; r++) res[k++] = a[r];
        for (int r = j; r < b.length; r++) res[k++] = b[r];
        return res;
    }

    /* This method prints integer type arrays */
    public static void printArr(int[] a){
        System.out.print("{");
        for (int i = 0; i < a.length-1; i++){
            System.out.print(a[i]+", ");
        }
        System.out.print(a[a.length-1]);
        System.out.println("}");
    }

    /* This method prints Comparable type arrays */
    public static void printArr(Comparable[] a){
        System.out.print("{");
        for (int i = 0; i < a.length-1; i++){
            System.out.print(a[i]+", ");
        }
        System.out.print(a[a.length-1]);
        System.out.println("}");
    }
}
