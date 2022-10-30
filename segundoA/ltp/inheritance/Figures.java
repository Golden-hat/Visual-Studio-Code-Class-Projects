public abstract class Figures{

    private double x;
    private double y;

    public Figures(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public abstract double area();

    @Override
    public String toString(){
        return("Located at: ("+x+", "+y+")");
    }
}   
