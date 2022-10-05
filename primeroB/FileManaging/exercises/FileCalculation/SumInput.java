package primeroB.FileManaging.exercises.FileCalculation;
import java.io.*;
import java.util.*;

public class SumInput {
    public static final String fileInName = "D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/FileManaging/exercises/FileCalculation/FileIn.txt";
    public static final String fileOutName = "D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/FileManaging/exercises/FileCalculation/FileOut.txt";
    public static Scanner sc = null;
    public static PrintWriter pw = null;

    public static void main(String[] args) throws FileNotFoundException{
        ReadFileAndReturnResult(fileInName, fileOutName);
    }

    public static void ReadFileAndReturnResult(String fIn, String fOut) throws FileNotFoundException{
        File filein = new File(fIn);
        File fileout = new File(fOut);

        int counter = 0;

        sc = new Scanner(filein);
        pw = new PrintWriter(fileout);

        while(sc.hasNext()){
            try{
                int sum = sc.nextInt();
                pw.println(sum);
                counter += sum;
            }
            catch(Exception e){
                pw.println("(Error: "+sc.next()+")");
            }
        }
        pw.println("Suma: "+counter);
        pw.close(); sc.close();
    }
}
