package topic2;

public class ejercicios2{
    public static void main(String[] args){
        int[] a = {-5, -4, -3, -2, -1, 1, 2, 3, 4};
        int[] b = {33,10,8,0,1,9};
        System.out.println(arrayIntegersCurveLinear(a));
        System.out.println(arrayIntegersCurveLog(a));
        System.out.println(concaveCurve(b));
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
}
