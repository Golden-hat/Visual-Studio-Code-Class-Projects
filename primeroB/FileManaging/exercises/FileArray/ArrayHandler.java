package primeroB.FileManaging.exercises.FileArray;
import java.io.*;

public class ArrayHandler {

    public static final String FileName = "D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/FileManaging/FileArray/ArrayElements.txt";
    public static PrintWriter pw = null;

    public static void main(String[] args) {
        int[] a = {5, 2, 8, 4};
        PrintArrayIntoFile(a);
    }

    public static File PrintArrayIntoFile(int[] a){
        File f = new File(FileName);

        try{
            pw = new PrintWriter(f);
            for(int i = 0; i < a.length; i++){
                int n = a[i];
                pw.println(n);
            }
        }catch(FileNotFoundException e){
            System.err.println("Error: "+e+"File does not exist!");
        }
        finally{
            if(pw != null){
                pw.close();
            }
        }
        return f;
    }
}
