/**
 * class Circle.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class Circle extends Figure {
    private double radius;

    public Circle(double x, double y, double r) {
        super(x, y);
        radius = r;
    }

    public String toString() {
        return "Circle:\n\t" +
            super.toString() +
            "\n\tRadius: " + radius;
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }

    public double area(){
        return Math.PI * radius * radius;
    }
}