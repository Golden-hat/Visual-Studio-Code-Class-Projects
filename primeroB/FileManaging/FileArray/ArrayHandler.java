package primeroB.FileManaging.FileArray;
import java.io.*;

public class ArrayHandler {

    public static final String FileName = "D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/FileManaging/FileArray/ArrayElements.txt";
    public static PrintWriter pw = null;

    public static void main(String[] args) {
        int[] a = {5, 2, 8, 4};
        PrintArrayIntoFile(a);
    }

    public static void PrintArrayIntoFile(int[] a){
        File f = new File(FileName);

        try{
            pw = new PrintWriter(f);
            for(int i = 0; i < a.length; i++){
                int n = a[i];
                pw.println(n);
            }
            pw.close();
        }catch(FileNotFoundException e){
            System.err.println("File does not exist!");
        }
    }
}
