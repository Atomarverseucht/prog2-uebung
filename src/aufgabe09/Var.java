package aufgabe09;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Var implements Expression {

    final String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public double eval(Map<String, Double> varBel){
        return varBel.get(name);
    }

    @Override
    public Set<String> getVars(){
        Set<String> out = new TreeSet<String>();
        out.add(name);
        return out;
    }
}
