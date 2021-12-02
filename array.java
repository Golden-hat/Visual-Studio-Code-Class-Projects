public class array {
    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 54, 9, 10, 11, 12, 13, 14};
        printArr(a);
        System.out.println();
        System.out.println(maximum(a));
    }

    public static void swap(int [] a, int j, int k){
        int temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    public static void printArr(int [] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static int maximum(int[] a){
        int pos = 0;
        
        for(int i = 1; i<a.length; i++){
            if(a[i] > a[pos]){
                pos = i;
            }
        }
        return pos;
    }
}
