using System;

class persona{
    int age;
    int favoriteNumber;
    string Name;
    string Surname;

    public persona(string name, string surname, int n, int f){
        this.Name = name;
        this.Surname = surname;
        age = n;
        favoriteNumber = f;
    }

    public void printPersona(){
        Console.WriteLine(Name+", "+Surname+", "+age+", "+favoriteNumber+"\n.");
    }
}

class main{
    public static void Main(){
        persona p = new persona("Yassin", "Pellicer Lamla",19, 23);
        p.printPersona();
    }
}
