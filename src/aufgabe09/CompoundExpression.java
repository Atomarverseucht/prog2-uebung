package aufgabe09;

import java.util.*;

public abstract class CompoundExpression implements Expression {
    protected Expression left;
    protected Expression right;

    public CompoundExpression(Expression e1, Expression e2) {
        left = e1;
        right = e2;
    }

    @Override
    public Set<String> getVars(){
        Set<String> out = new TreeSet<String>();
        out.addAll(left.getVars());
        out.addAll(right.getVars());
        return out;
    }
}
