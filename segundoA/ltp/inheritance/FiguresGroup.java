public class FiguresGroup {

    public static int MAXSIZE;
    public static int size;
    public static Figures[] figArr;

    public FiguresGroup(int MAXSIZE){
        figArr = new Figures[MAXSIZE];
        size = 0;
    }

    public void addToGroup(Figures f){
        if(size != MAXSIZE-1){
            figArr[size++] = f;
        }
        else{
            return;
        }
    }

    public void printFigs(){
        for(int i = 0; i < size; i++){
            System.out.println(figArr[i]);
            System.out.println();
        }
    }

    public double totArea(){
        double area = 0.0;
        for(int i = 0; i < size; i++){
            area += figArr[i].area();
        }
        return area;
    }

    public Figures greatestFigure(){
        Figures aux = figArr[0]; 
        for(int i = 0; i < size; i++){
            if(figArr[i].area() > aux.area());
            aux = figArr[i];
        }
        return aux;
    }

    public static void main(String[] args) {
        FiguresGroup n = new FiguresGroup(100);
        Figures s = new Circle(5, 4, 3);
        Figures t = new Circle(5, 4, 6);
        Figures v = new Circle(5, 3, 10);
        n.addToGroup(s);
        n.addToGroup(t);
        n.addToGroup(v);
        n.printFigs();
        System.out.println(n.greatestFigure());
    }

}
