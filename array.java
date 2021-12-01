public class array {
    public static void main(String[] args) {
        int a[] = new int[]{0, 0, 4, 3, 4, 0, 0, 7, 8, 9, 0, 0, 0, 13, 14};
        System.out.println(maximum(a));
        System.out.println(periodOfThree(a));
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

    public static int periodOfThree(int[] a){
        int counter = 0;
        
        for (int i = 1; i < a.length; i++){

            if(a[i] > 0){
                ++counter;
            }else{
                counter = 0;
            }

            if (counter > 3){
                return (i - counter +1);
            }
        }   
        return -1;
    }
}
