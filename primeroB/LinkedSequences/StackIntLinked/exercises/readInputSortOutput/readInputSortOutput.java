package primeroB.LinkedSequences.StackIntLinked.exercises.readInputSortOutput;
import primeroB.LinkedSequences.StackIntLinked.*;
import java.io.*;
import java.util.*;

public class readInputSortOutput {
    public static void main(String[] args) throws FileNotFoundException{
        StackIntLinked k = new StackIntLinked();
        StackIntLinked p = new StackIntLinked();
        File f = new File("D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/LinkedSequences/StackIntLinked/exercises/readInputSortOutput/fileIn.txt");
        PrintWriter pw = new PrintWriter("D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/LinkedSequences/StackIntLinked/exercises/readInputSortOutput/fileOut.txt");

        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            int n = sc.nextInt();
            k.push(n);
        }

        while(!k.empty()){
            if(k.pop().getData() >= 5){
                p.push(k.pop().getData());
            }
            k.push(k.pop().getData());
        }
        k.toString();
        p.toString();
        pw.close(); sc.close();
    }
}
