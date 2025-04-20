package aufgabe5;

public static class PythagorasTree {
    public static void main(String[] args) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.01);
       // StdDraw.filledRectangle(0.1,0.1,0.5,0.3);
        StdDraw.square(0.1,0.1,0.1);
    }

    public static void v1(double minLength, double angle, double x1, double y1, double x2, double y2) {
        if(delta(x1,y1,x2,y2) <= minLength) { return; }

    }

    public static double delta(double x1, double y1, double x2,double y2){
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
    }
}
