package aufgabe5;

public class PythagorasTree {
    public static void main(String[] args) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.001);
        // StdDraw.filledRectangle(0.1,0.1,0.5,0.3);
        // StdDraw.square(0.1,0.1,0.1);
        v1(0.001, 0.78539816339, new Position(0.3,0.1), new Position(0.4, 0.15));
    }

    /// @param angle Winkel in Bogenmaß
    public static void v1(double minLength, double angle, Position p1, Position p2){
        if(p1.deltaAmount(p2) <= minLength){ return;}
        Position[] p = drawRotatedSquare(p1, p2);
        p = drawRotatedTriangle(p[2], p[3], angle);
    }

    public static Position[] drawRotatedSquare(Position a, Position b){

        Position delta = a.deltaPosition(b);
        Position d = new Position(a.x() - delta.y(), a.y() + delta.x());
        Position c = new Position(b.x() - delta.y(), b.y() + delta.x());
        a.drawLine(b);
        StdDraw.setPenColor(StdDraw.BLUE);
        b.drawLine(c);
        c.drawLine(d);
        d.drawLine(a);
        Position[] pos = {a,b,c,d};
        return pos;
    }

    public static Position[] drawRotatedTriangle(Position a, Position b, double angle){
        double ab = a.deltaAmount(b);
        double ac = ab * Math.cos(angle);
        double beta = Math.acos(- a.deltaPosition(b).x() / ab);
        double alpha = angle + beta;
        Position c = new Position((a.x() + ac * Math.cos(alpha)), (a.y() + ac * Math.sin(alpha)));
        a.drawLine(c);
        b.drawLine(c);
        Position[] p = {a, b, c};
        return p;
    }

}
