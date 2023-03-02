package topic2;

public class ejercicios2{
    public static void main(String[] args){
        Integer[] c = {-5, -4, -3, -2, -1, 1, 2, 3, 4};
        Integer[] d = {0,1,5,7,19,52};
        Integer[] mergeS = {0,1,5,7,19,52,2,3,6,3,4,7,345,678,24523};

        int[] a = {-5, -4, -3, -2, -1, 1, 2, 3, 4};
        int[] b = {33,10,8,0,1,9};

        System.out.println(arrayIntegersCurveLinear(a));
        System.out.println(arrayIntegersCurveLog(a));
        System.out.println(concaveCurve(b));
        mergeSort(mergeS);
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

    public static <T extends Comparable<T>> void mergeSort(T[] array){
        mergeSort(array, 0, array.length-1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right){

        if(left < right){
            int m = (left + right)/2;
            mergeSort(array, 0, m);
            mergeSort(array, m+1, right);

            mergeDC(array, left, m+1, right); 
        }
        if (array.length < 2) {
            return;
        }
    }
    
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

    public static <E extends Comparable<E>> void mergeDC(E[] a, int left, int mid, int right){
        E[] res = (E[]) new Comparable[a.length];
        
        E[] izq = (E[]) new Comparable[a.length/2+1];
        E[] der = (E[]) new Comparable[a.length/2+1];

        for(int i = 0; i < a.length/2 + 1; i++){
            izq[i] = a[i];
            der[i] = a[a.length/2 + i];
        }
        
        // Esta primera parte se encarga de meter los numeros en orden ascendente de cada array
        // hasta que alguno de los dos se extenúe.
        int i = 0, j = 0, k = 0;
        while (i < izq.length && j < der.length) {
            if (izq[i].compareTo(der[j]) < 0) res[k++] = izq[i++];
            else res[k++] = der[j++];
        }
        // Esta segunda parte completa con los números faltantes del array no extenuado.
        for (int r = i; r < izq.length; r++) res[k++] = izq[r];
        for (int r = j; r < der.length; r++) res[k++] = der[r];

        for(i = 0; i < res.length + 1; i++){
            a[i] = res[i];
        }
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
