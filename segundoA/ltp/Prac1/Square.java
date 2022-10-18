public class Square extends Rectangle {

    private double l;

    public Square(double x, double y, double h) {
        super(x, y, h, h);
        this.l = h;
    }

    public String toString() {
        return "Square:\n\t" +
            super.toString() +
            "\n\tBase: " + l +
            "\n\tHeight: " + l;
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }
    
}
