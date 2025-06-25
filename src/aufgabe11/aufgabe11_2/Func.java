package aufgabe11.aufgabe11_2;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Func implements Expression{
    final Function<Double, Double> fun;
    final Expression x;
    @Override
    public double eval(Map<String, Double> varBel) {
        return fun.apply(x.eval(varBel));
    }

    @Override
    public Set<String> getVars() {
        return x.getVars();
    }

    public Func(Function<Double, Double> fun, Expression x){
        this.fun = fun;
        this.x = x;
    }
}
