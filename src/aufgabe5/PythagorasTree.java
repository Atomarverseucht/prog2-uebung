package aufgabe5;

public class PythagorasTree {
    public static void main(String[] args) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.01);
        // StdDraw.filledRectangle(0.1,0.1,0.5,0.3);
        // StdDraw.square(0.1,0.1,0.1);
        v1(0.001, 0.2, new Position(0.5,0.5), new Position(0.4, 0.7));
    }

    public static void v1(double minLength, double angle, double x1, double y1, double x2, double y2) {
        if(delta(x1,y1,x2,y2) <= minLength) { return; }

    }

    public static void v1(double minLength, double angle, Position p1, Position p2){
        if(p1.deltaAmount(p2) <= minLength){ return;}
        Position[] rect = drawRotatedSquare(p1, p2);
        //Quadrat berechnen
    }

    public static Position[] drawRotatedSquare(Position a, Position b){

        Position delta = a.deltaPosition(b);
        Position d = new Position(a.x() - delta.y(), a.y() + delta.x());
        Position c = new Position(b.x() - delta.y(), b.y() + delta.x());
        a.drawLine(b);
        b.drawLine(c);
        c.drawLine(d);
        d.drawLine(a);
        Position[] pos = {a,b,c,d};
        return pos;
    }

    public static Position[] drawRotatedTriangle(Position a, Position b, double angle){
        return null;
    }

    public static double delta(double x1, double y1, double x2,double y2){
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
    }
}
