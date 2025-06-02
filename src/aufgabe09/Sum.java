package aufgabe09;

public class Sum extends CompoundExpression {

    public Sum(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public String toString(){
        return left + " + " + right;
    }
}
