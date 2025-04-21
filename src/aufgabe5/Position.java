package aufgabe5;

// This is a helping class
public final class Position {
    private final double x;
    private final double y;


    public static Position deltaPosition(Position p1, Position p2){
        double x, y;
        y = p1.y - p2.y;
        x = p1.x - p2.x;
        return new Position(x,y);
    }

    public static double deltaAmount(Position p1, Position p2){
        Position delta = deltaPosition(p1, p2);
        return delta.amount();
    }

    public double amount(){
        return Math.sqrt(x * x + y * y);
    }
    public Position (double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return y + "|" + x;
    }

    public double x(){ return x; }

    public double y(){ return y; }
}
