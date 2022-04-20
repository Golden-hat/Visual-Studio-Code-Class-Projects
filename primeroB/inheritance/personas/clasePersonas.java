package primeroB.inheritance.personas;

public class clasePersonas{
    protected int age;
    protected String name;
    
    public static int numberOfPeople = 0;

    public clasePersonas(int a, String n){
        this.age = a;
        this.name = n;
        numberOfPeople++;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public static int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public String toString(){
        return "This is "+getName()+", and he/she's "+getAge()+" years old.";
    }
}
