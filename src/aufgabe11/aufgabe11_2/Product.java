package aufgabe11.aufgabe11_2;

import java.util.Map;

public class Product extends CompoundExpression {

    public Product(Expression e1, Expression e2) {
        super(e1, e2);
        operator = '*';
    }

    @Override
    public double eval(Map<String, Double> varBel){
        return left.eval(varBel) * right.eval(varBel);
    }
}

