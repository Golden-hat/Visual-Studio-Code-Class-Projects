package ltp.practica2;

/**
 * class WrapperClassesUse.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class WrapperClassesUse {        
    public static void main(String[] args) {            
        // Assignment of wrapper variables to elementary types 
        int i = new Integer(123456);        
        double j = new Double(128.23);
        char k = new Character('x');
            
        // Writing elementary variables
        System.out.println("int i = " + i);
        System.out.println("double j = " + j);
        System.out.println("char k = " + k);
               
        // Assignment of elementary values to wrapper variables
        Integer eI = 123456;
        Double eD = 12.52;
        Character eC = 'c';
            
        // Writing wrapper variables
        System.out.println("Integer eI = " + eI);
        System.out.println("Double eD = " + eD);
        System.out.println("Character eC I = " + eC);
    }    
}