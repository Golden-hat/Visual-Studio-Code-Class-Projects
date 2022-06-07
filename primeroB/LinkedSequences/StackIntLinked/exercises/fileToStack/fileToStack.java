package primeroB.LinkedSequences.StackIntLinked.exercises.fileToStack;
import java.io.*;
import java.util.*;
import primeroB.LinkedSequences.StackIntLinked.StackIntLinked;

public class fileToStack {
    
    public static void main(String[] args) {
        String s = "D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/LinkedSequences/StackIntLinked/exercises/fileToStack/fileIn.txt";
        System.out.println(fileToStackConvert(s));
    }

    public static StackIntLinked fileToStackConvert(String fileName){
        Scanner sc = null;
        StackIntLinked k = new StackIntLinked();

        try{
            sc = new Scanner(new File(fileName));

            while(sc.hasNext()){
                try{
                    int n = sc.nextInt();
                    k.push(n);
                }
                catch(InputMismatchException e){
                    sc.nextLine();
                }
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File does not Exist!");
        }
        if(sc != null){
            sc.close();
        }
        return k;
    }
}
