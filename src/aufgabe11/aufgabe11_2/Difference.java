package aufgabe11.aufgabe11_2;

import java.util.Map;

public class Difference extends CompoundExpression {

    public Difference(Expression e1, Expression e2){
        super(e1, e2);
        operator = '-';
    }

    @Override
    public String toString(){
        return "(" + left + " - " + right + ")";
    }

    @Override
    public double eval(Map<String, Double> varBel){
        return left.eval(varBel) - right.eval(varBel);
    }
}
