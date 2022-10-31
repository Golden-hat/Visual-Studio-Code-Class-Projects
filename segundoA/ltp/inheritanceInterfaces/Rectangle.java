public class Rectangle extends Figures implements ComparableRange{

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

    public int compareToRange(Figures o){
        if(Math.abs(this.area() - o.area()) > 0.1*(this.area()+o.area())){
            return this.compareTo(o);
        }
        return 0;
    }

    public String toString(){
        return "\nRectangle, "+super.toString() 
        + ", and with height; width: ("+height+", "+width+")"+
        "\nA total area of: "+this.area()+"\n";
    }
}

