package aufgabe5;

// This is a helping class
public final class Position {
    private final double x;
    private final double y;


    public Position deltaPosition(Position p1){
        double x, y;
        y = p1.y - this.y;
        x = p1.x - this.x;
        return new Position(x,y);
    }

    public double deltaAmount(Position p1){
        Position delta = this.deltaPosition(p1);
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

    public void drawLine(Position target){
        StdDraw.line(x, y, target.x(), target.y());
    }
}
