package aufgabe09;

public abstract class CompoundExpression implements Expression {
    protected Expression left;
    protected Expression right;

    public CompoundExpression(Expression e1, Expression e2) {
        left = e1;
        right = e2;
    }
}
