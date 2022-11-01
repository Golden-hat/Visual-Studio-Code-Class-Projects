public class Square extends Rectangle {

    private double side;

    public Square(double x, double y, double side){
        super(x, y, side, side);
    }

    public double getSide() {
        return side;
    }

    public String toString(){
        return "\nSquare, Located at: ("+super.getX()+", "+super.getY()+")"
        +", and with side: ("+super.getHeight()+")"+
        "\nA total area of: "+super.area()+"\n";
    }
}
