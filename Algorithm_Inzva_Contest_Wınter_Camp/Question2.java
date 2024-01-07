import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        Point p1 = new Point(x1, y1);
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        Point p2 = new Point(x2, y2);
        int x3 = scan.nextInt();
        int y3= scan.nextInt();
        Point p3 = new Point(x3, y3);
        Triangle t1 = new Triangle(p1, p2, p3);
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        p1 = new Point(x1, y1);
        x2 = scan.nextInt();
        y2 = scan.nextInt();
        p2 = new Point(x2, y2);
        x3 = scan.nextInt();
        y3= scan.nextInt();
        p3 = new Point(x3, y3);
        Triangle t2 = new Triangle(p1, p2, p3);
        System.out.println(ConstructNthTriangle(t1, t2, n));
        
    }

    public static int Diff(Point p1,Point p2){
        return p1.x - p2.x + p1.y - p2.y;
    }

    public static int Power(Triangle t){
        return Diff(t.p2, t.p1) + Diff(t.p3, t.p1);
    }

    /*
    public static int PowerNth(Triangle t1,Triangle t2,int N){

        if(N == 1)
            return Power(t1);
        else if(N == 2)
            return Power(t2);
        else{
            

        }

    }
    */

    public static int ConstructNthTriangle(Triangle t1,Triangle t2,int N){

        if(N == 1)
            return Power(t1);
        else if(N == 2)
            return Power(t2);
        else{
            int n = 3;
            Triangle result = null;
            while(n <= N){
                result = makeTriangle(t1, t2);
                t1 = t2;
                t2 = result;
                n++;
            }
            return Power(result);
        }

    }

    public static Triangle makeTriangle(Triangle t1,Triangle t2){
        return new Triangle(t1.p1, new Point(t1.p2.x+Power(t2), t1.p2.y+Power(t2)), new Point(t1.p3.x + Power(t1), t1.p3.y + Power(t1)));
    }
    
}

class Triangle{
    public Point p1;
    public Point p2;
    public Point p3;
    Triangle(Point p1, Point p2,Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
}

class Point{
    public int x;
    public int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}