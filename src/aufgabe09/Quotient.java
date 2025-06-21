package aufgabe09;

import java.util.Map;

public class Quotient extends CompoundExpression {

    public Quotient(Expression e1, Expression e2) {
        super(e1, e2);
        operator = '/';
    }

    @Override
    public double eval(Map<String, Double> varBel){
        return left.eval(varBel) / right.eval(varBel);
    }
}
