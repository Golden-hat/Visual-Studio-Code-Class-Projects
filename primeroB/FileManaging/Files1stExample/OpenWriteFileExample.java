package primeroB.FileManaging.Files1stExample;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class OpenWriteFileExample {
    public static final String FileName= "D:/Proyectos código/Visual-Studio-Code-Class-Projects/primeroB/FileManaging/Files1stExample/fileExample.txt";
    public static File f = new File(FileName); 
    // The path must be written from the disk direction.
    public static Scanner sc = null;
    public static PrintWriter pw = null; 
    
    public static void main(String[] args) {
        NameAndPathIfExists(f);
        PrintInFileString("Hola!!!");

        LoadFromFile();
    }

    public static void NameAndPathIfExists(File f){
        if (f.exists()) {
            System.out.println("File exists!"); // .exists() is a boolean method implemented in the library.
            System.out.println("Name of the file is: " + f.getName() + ". It's size is: " + f.length()); // .length() gives the size of the file.
            System.out.println("Path of the file is: " + f.getParentFile());
        }
        else System.err.println("File doesn't exist!");
    }

    public static void PrintInFileString(String s){
        try{
            pw = new PrintWriter(new FileOutputStream(FileName, true));
            //THE DIFFERENCE BETWEEN FileOutputStream and PrintWriter is that the former MAINTAINS ALL PREVIOUSLY WRITTEN DATA, WHILE THE LATTER DELETES IT.
            //The printWriter declaration must be wrapped within try clauses in order to avoid unhandled exceptions. Otherwise code won't even compile.
            pw.println(s);
            pw.close();
            System.out.println("The following line has been saved into the txt. file: «"+s+"»");
        }catch(Exception e){
            System.err.println("File doesn't exist!");
        }
        pw.close();
    }

    public static void LoadFromFile(){
        try{
            sc = new Scanner(new File(FileName));
            //The scanner declaration must be wrapped within try clauses in order to avoid unhandled exceptions. Otherwise code won't even compile.
            System.out.println("\nThe following line(s) have been read from the txt. file: \n");
            while(sc.hasNextLine()){
                String readElement = sc.nextLine();
                System.out.println(readElement);
            }
        }catch(Exception e){
            System.err.println("File doesn't exist!");
        }
        sc.close();
    }
}
