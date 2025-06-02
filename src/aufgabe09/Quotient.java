package aufgabe09;

public class Quotient extends CompoundExpression {

    public Quotient(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public String toString(){
        return left + " : " + right;
    }
}
