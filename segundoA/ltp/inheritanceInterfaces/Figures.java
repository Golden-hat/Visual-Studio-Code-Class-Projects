public abstract class Figures implements Comparable<Figures>{ 

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

    public int compareTo(Figures f){
        if(this.area() > f.area()){
            return 1;
        }
        else if (this.area() < f.area()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString(){
        return("Located at: ("+x+", "+y+")");
    }
}   
