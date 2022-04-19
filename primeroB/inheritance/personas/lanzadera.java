package primeroB.inheritance.personas;

public class lanzadera{
    public static void main(String[] args){

        claseEstudiante p = new claseEstudiante(20, "Madalina", 1);
        clasePersonas n = new clasePersonas(24, "Eduardo");

        System.out.println(p);
        System.out.println(n);

        System.out.println(clasePersonas.getNumberOfPeople());
    }
}
