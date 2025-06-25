package aufgabe11.aufgabe11_2;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Constant implements Expression {

    final double value;

    public Constant(double val) {
        this.value = val;
    }

    @Override
    public String toString(){
        return Double.toString(value);
    }

    @Override
    public double eval(Map<String, Double> varBel){
        return value;
    }

    @Override
    public Set<String> getVars(){
        return new TreeSet<>();
    }
}
