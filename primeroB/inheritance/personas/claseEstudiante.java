package primeroB.inheritance.personas;

public class claseEstudiante extends clasePersonas{
    
    private int numerodeSuspensos;

    public claseEstudiante(int a, String n, int j){
        super(a, n);
        numerodeSuspensos = j;
    }

    public int getNumerodeSuspensos() {
        return numerodeSuspensos;
    }

    public String toString(){
        return "This is "+super.getName()+", he/she's "+super.getAge()+" years old"+" and he/she's failed a total of " +getNumerodeSuspensos()+" subject(s).";
    }
}
