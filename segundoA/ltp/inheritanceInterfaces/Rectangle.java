public class Rectangle extends Figures{

    private double height;
    private double width;

    public Rectangle(double x, double y, double width, double height){
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }

    public double area(){
        return height*width;
    }

    public String toString(){
        return "\nRectangle, "+super.toString() 
        + ", and with height; width: ("+height+", "+width+")"+
        "\nA total area of: "+this.area()+"\n";
    }
}

