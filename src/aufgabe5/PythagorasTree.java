package aufgabe5;

import java.awt.*;

public class PythagorasTree {
    public static int w = 1000;
    public static int h = 750;
    public static void main(String[] args) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        // StdDraw.filledRectangle(0.1,0.1,0.5,0.3);
        // StdDraw.square(0.1,0.1,0.1);
        //v1(2, Math.toRadians(20), new Position(700,200), new Position(800, 200));
        v2(2, new Position(550,0), new Position(600, 0));
    }

    /// @param angle Winkel in Bogenmaß
    public static void v1(double minLength, double angle, Position p1, Position p2){
        if(p1.deltaAmount(p2) <= minLength){ return;}
        StdDraw.setPenColor(new Color(175, 50, 0));
        if(p1.deltaAmount(p2) <= 10){
            StdDraw.setPenColor(Color.green);
        }
        Position[] p = drawRotatedSquare(p1, p2);
        p = drawRotatedTriangle(p[3], p[2], angle);
        v1(minLength, angle, p[0], p[2]);
        v1(minLength, angle, p[2], p[1]);
    }

    public static void v2(double minLength, Position p1, Position p2){
        if(p1.deltaAmount(p2) <= minLength){ return;}
        StdDraw.setPenColor(new Color(175, 50, 0));
        if(p1.deltaAmount(p2) <= 10){
            StdDraw.setPenColor(Color.green);
        }
        Position[] p = drawRotatedRect(p1, p2);
        p = drawRotatedTriangle(p[3], p[2], (Math.random()/2)*Math.PI);
        v2(minLength, p[0], p[2]);
        v2(minLength, p[2], p[1]);
    }

    public static Position[] drawRotatedRect(Position a, Position b){
        Position delta = a.deltaPosition(b);
        double v = Math.random()*3 + 0.1;
        Position d = new Position(a.x() - v * delta.y(), a.y() + v* delta.x());
        Position c = new Position(b.x() - v * delta.y(), b.y() + v* delta.x());
        a.drawLine(b);
        b.drawLine(c);
        c.drawLine(d);
        d.drawLine(a);
        Position[] pos = {a,b,c,d};
        return pos;
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
        Position delta = a.deltaPosition(b);
        double ab = delta.amount();
        double gamma = Math.atan2(delta.y(), delta.x());
        double ac = Math.cos(angle) * ab;
        angle += gamma;
        Position c = new Position(a.x() + ac * Math.cos(angle), a.y() + ac * Math.sin(angle) );
        Position[] out = {a, b, c};
        a.drawLine(c);
        b.drawLine(c);
        return out;
    }

}
