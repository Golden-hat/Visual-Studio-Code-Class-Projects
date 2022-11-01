public class Circle extends Figures{

    private double radius;

    public Circle(double x, double y, double radius){
        super(x, y);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double area(){
        return(Math.PI*radius*radius);
    }

    public String toString(){
        return "\nCircle, "+super.toString() 
        + ", and with radius: "+this.getRadius()+
        "\nA total area of: "+this.area()+"\n";
    }
}
