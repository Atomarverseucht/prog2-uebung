package aufgabe09;

public class Constant implements Expression {

    final double value;

    public Constant(double val) {
        this.value = val;
    }

    @Override
    public String toString(){
        return Double.toString(value);
    }
}
