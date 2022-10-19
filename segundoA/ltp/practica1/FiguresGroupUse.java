
/**
 * class FiguresGroupUse.
 * 
 * @author LTP 
 * @version 2020-21
 */
public class FiguresGroupUse {
    public static void main(String[] args) {
        FiguresGroup g = new FiguresGroup();
        FiguresGroup t = new FiguresGroup();
        t.add(new Circle(10, 53, 3.5));
        t.add(new Circle(10, 53, 6.5));
        g.add(new Circle(10, 5, 3.5));
        g.add(new Triangle(10, 5, 6.5, 32));
        g.add(new Rectangle(10, 50, 6.5, 92));
        System.out.println(g.greatestFigure());
        System.out.println(t.greatestFigure());
        System.out.println(g);
        System.out.println(t);
    }
}