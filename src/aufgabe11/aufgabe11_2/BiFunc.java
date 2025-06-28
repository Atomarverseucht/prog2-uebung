package aufgabe11.aufgabe11_2;


import java.util.Map;
import java.util.function.BiFunction;

public class BiFunc extends CompoundExpression {
    final BiFunction<Double, Double, Double> bf;
    public BiFunc(BiFunction<Double, Double, Double> bf, Expression e1, Expression e2) {
        super(e1, e2);
        this.bf = bf;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return bf.apply(left.eval(varBel), right.eval(varBel));
    }

    @Override
    public String toString() {
        operator = ',';
        return "g" + super.toString();
    }
}
