package primeroA;

// height = widht, así que no te rayes por favor.

public class triangle{
    public static void main(String[] args) {
       Rombo(30, 15);
    }

    public static void lines(int width, char symbol){
        for(int i = 1; i <= width; i++){
            System.out.print(symbol);
        }
    }   

    public static void square(int width){
        for (int i = 1; i <= width; i++){
            lines(width, '*');
            System.out.println(); 
        }
    }

    public static void triangleRight(int height){
        for (int i = 1; i <= height; i++){
            lines(i, '*');
            System.out.println();
        }
    }

    public static void triangleLeft(int height){
        for (int i = 1; i <= height; i++){
            lines(height-i, ' ');
            lines(i, '*');
            System.out.println();
        }
    }

    public static void OffsetTriangleToTheRight(int offset, int height){
        for (int i = 1; i <= height; i++){
            lines(offset, ' ');
            lines(i, '*');
            System.out.println();
        }
    }

    public static void OffsetTriangleToTheLeft(int offset, int height){
        for (int i = 1; i <= height; i++){
            lines(offset+height-i, ' ');
            lines(i, '*');
            System.out.println();
        }
    }

    //Offset TIENE que ser más grande que height y se toma desde la punta
    public static void CenterTriangle(int offset, int height){
        for (int i = 0; i <= height; i++){
            lines(offset-i, ' ');
            lines(2*i+1, '*');
            System.out.println();
        }
    }

    //Offset se toma desde la primera línea
    public static void InverseCenterTriangle(int offset, int height){
        for (int i = 0; i <= height; i++){
            lines(offset+i, ' ');
            lines(height*2-2*i+1, '*');
            System.out.println();
        }
    }

    public static void Rombo(int offset, int height){
            CenterTriangle(offset, height/2);
            InverseCenterTriangle(offset-height/2 + 1, height/2 - 1);
    }

}