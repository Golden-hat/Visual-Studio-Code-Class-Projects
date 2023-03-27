package examples.topic2;

public class ejercicios2{
    public static void main(String[] args){
        Integer[] c = {-5, -4, -3, -2, -1, 1, 2, 3, 4};
        Integer[] d = {0,1,5,7,19,52};
        Integer[] mergeS = {0,1,5,7,19,52,2,3,6,3,4,7,345,678,24523};

        int[] a = {-5, -4, -3, -2, -1, 1, 2, 3, 4};
        int[] b = {33,10,8,1532,11,9235,25,56,12345,7456,2,45,26,47356,236,4768,45,-5634,-37};

        printArr(b);
        mergeSortTwo(b);
        printArr(b);
        
        printArr(mergeS);
        mergeSort(mergeS);
        printArr(mergeS);
    }
    
    /*  1.1. Let v be an array of integers conforming to the profile of a continuous
        monotonically increasing curve, such that v[0]<0 and v[v.length-1]>0.
        There exists a unique position k of v, 0≤k<v.length-1, such that between v[k] and v[k+1]
        the function is 0, i.e. such that v[k]≤0 and v[k+1]>0.
        Design the "best" recursive method that computes k and analyse its cost.    */ 
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

    /*  Exercise 1.2: Let v be an array of positive integers that conform to the profile of a
        concave curve, i.e. there exists a unique position k of v, 0≤k<v.length, such that:
        "j : 0≤j<k : v[j]>v[j+1] & "j : k<j<v.length : v[j-1]<v[j].
        Design the best recursive method that computes k and analyse its cost   */
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

    /*  1.3. Design a recursive method that, with the least
        possible cost, determines whether an array v of integers, sorted in ascending order and
        with no repeated elements, contains any component whose value is equal to the
        position it occupies.  */
    public static int isAnyInPos(int[] e){
        return isAnyInPos(e, 0, e.length-1);
    }

    public static int isAnyInPos(int[] e, int ini, int fin){
        if(ini > fin) return -1;
        int middle = (fin+ini)/2;
        if(e[middle] == middle){return middle;}
        if(e[middle] > middle){return isAnyInPos(e, ini, middle-1);}
        return isAnyInPos(e, middle+1, fin);
    }

    /*  Exercise 1.4. Design the best recursive method that searches for two Strings in
        consecutive positions of an array.
        The method, with the lowest possible cost, checks whether two Strings x and y (such
        that x is strictly less than y) occupy consecutive positions in an array of String v, sorted
        in ascending order and with no repeated elements. */
    public static boolean consecutiveString(String[] a, String x, String y){
        return consecutiveString(a, x, y, 0, a.length-1);
    }

    public static boolean consecutiveString(String[] a, String x, String y, int ini, int fin){
        int middle = (fin+ini)/2;
        if(ini > fin){
            return false;
        }
        if (ini == a.length - 1) return false;
        if(a[middle].compareTo(y) < 0){
            return consecutiveString(a, x, y, ini, middle-1);
        }
        else if (a[middle].equals(y)){
            return a[middle-1].equals(y);    
        }
        return consecutiveString(a, x, y, middle+1, fin);
    }

    /*  Exercise 2.5: Given an array of n integers in ascending order, with values in the range [1
        ... n], we want to find, if it exists, the only integer value that is repeated. If no repeated
        element is found, it shall be denoted by the special value -1.  */
    public static int repeatedInteger(int[] n){
        return repeatedInteger(n, 0, n.length-1);
    }

    public static int repeatedInteger(int[] n, int ini, int fin){
        int middle = fin+ini/2;
        if(ini > fin){return -1;}
        /* Un array ascendente cuya diferencia entre elementos no supera la unidad y que 
            * únicamente puede tener un elemento repetido (donde sí o sí ambos aparecerán pegados)
            * quiere decir que todos los números antes de la duplicación estarán en una posición tal
            * que su valor coincidirá con su índice + (MÁS! IMPORTANTE) el valor del primer elemento
            * del array.
            * 
            * Sabiendo esto...
            */
        if(n[middle] != middle + n[0]){
            /* Se comprueba si el elemento del medio se encuentra en el lugar correspondiente,
                * en ese caso, se cogerá la parte del array superior (ver línea 14).
                * En caso contrario, o bien...
                *      primero comprobamos para ver si el medio analizado tiene al número repetido, o...
                *      cogemos la parte inferior, ya que sabremos que la repetición ya se ha dado anteriormente.
                */
            if (middle > 0 && n[middle] == n[middle-1]) { return n[middle]; }
            return repeatedInteger(n, ini, middle-1);

        }
        return repeatedInteger(n, middle+1, fin);
    }

    /*  Exercise 2.6: Implement an efficient recursive method that, given a non-empty array of
        integers, sorted in ascending order and with no repeated elements, returns the first
        omitted value that would make its elements consecutive. If there is no missing value,
        the next value in sequence is returned.  */
    public static int missingValue(int[] n){
        return missingValue(n, 0, n.length-1);
    }

    public static int missingValue(int[] n, int ini, int fin){
        if (ini > fin || n[ini] != n[0] + ini) return n[0] + ini;
        int m = (ini + fin) / 2;
        if (n[m] == n[0] + m) return missingValue(n, m + 1, fin);
        else return missingValue(n, ini, m - 1);
    }

    /* ---------------------------------- MERGE SORT WITH INTEGER ARRAYS ----------------------------------  */

    /* --------- void methods, where the array is modified in each call --------- */

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

    /* --------- int[] methods, where the array is modified only when needed --------- */

    public static void mergeSortTwo(int[] a){
        int[] ret = mergeSortTwo(a, 0, a.length-1);
        for(int i = 0; i < a.length; i++){
            a[i] = ret[i];
        }
    }

    private static int[] mergeSortTwo(int[] a, int ini, int fin){
        int mid = (fin+ini)/2;

        if(fin-ini == 1){
            if(a[ini] < a[fin]){
                return new int[]{a[ini], a[fin]};
            }
            else{
                return new int[]{a[fin], a[ini]};
            }
        }
        else if(ini < fin){
            int[] left = mergeSortTwo(a, ini, mid);
            int[] right = mergeSortTwo(a, mid+1, fin);
            return mergeTwo(left, right);
        }
        return new int[]{a[ini]};
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

    /* ---------------------------------- MERGE SORT WITH GENERIC ARRAYS ----------------------------------*/

    /* --------- void methods, where the array is modified in each call --------- */

    public static <E extends Comparable<E>> void mergeSort(E[] a){
        mergeSort(a, 0, a.length-1);
    }

    private static <E extends Comparable <E>> void mergeSort(E[] a, int ini, int fin){
        int mid = (ini+fin)/2;
        if(ini < fin){
            mergeSort(a,ini,mid);
            mergeSort(a,mid+1,fin);
            merge(a, ini, mid, fin);
        }
        else{
            return;
        }
    }

    private static <E extends Comparable <E>> void merge(E[] a, int ini, int mid, int fin){
        E[] aux = (E[]) new Comparable[fin-ini+1]; 

        int i = ini, j = mid+1, k = 0;
        while(i <= mid && j <= fin){
            if(a[i].compareTo(a[j]) < 0){
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

    /* --------- E[] methods, where the array is modified only when needed --------- */
    
    public static <E extends Comparable<E>> void mergeSortTwo(E[] a){
        E[] ret = mergeSortTwo(a, 0, a.length-1);
        for(int i = 0; i < a.length; i++){
            a[i] = ret[i];
        }
    }

    private static <E extends Comparable<E>> E[] mergeSortTwo(E[] a, int ini, int fin){
        int mid = (fin+ini)/2;

        if(fin-ini == 1){
            if(a[ini].compareTo(a[fin]) < 0){
                return (E[]) new Comparable[]{a[ini], a[fin]};
            }
            else{
                return (E[]) new Comparable[]{a[fin], a[ini]};
            }
        }
        else if(ini < fin){
            E[] left = mergeSortTwo(a, ini, mid);
            E[] right = mergeSortTwo(a, mid+1, fin);
            return merge(left, right);
        }
        return (E[]) new Comparable[]{a[ini]};
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

    /* ---------------------------------- PRINT ARRAY MEHTODS ---------------------------------- */

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
