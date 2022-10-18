public class Rectangle extends Figure{

    private double base; 
    private double height;

    public Rectangle(double x, double y, double b, double h) {
        super(x, y);
        base = b;
        height = h;
    }

    public String toString() {
        return "Rectangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }
    
    public double area(){
        return base*height;
    }
}
