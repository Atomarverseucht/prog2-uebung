package aufgabe11.aufgabe11_2;


import java.util.Map;
import java.util.function.BiFunction;

public class biFunc extends CompoundExpression {
    final BiFunction<Double, Double, Double> bf;
    public biFunc(Expression e1, Expression e2, BiFunction<Double, Double, Double> bf) {
        super(e1, e2);
        this.bf = bf;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return bf.apply(left.eval(varBel), right.eval(varBel));
    }
}
