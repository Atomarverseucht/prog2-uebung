package aufgabe09;

import java.util.*;

public abstract class CompoundExpression implements Expression {
    protected Expression left;
    protected Expression right;
    protected char operator;

    public CompoundExpression(Expression e1, Expression e2) {
        left = e1;
        right = e2;
    }

    @Override
    public Set<String> getVars(){
        Set<String> out = new TreeSet<>();
        out.addAll(left.getVars());
        out.addAll(right.getVars());
        return out;
    }

    @Override
    public String toString(){
        return  "(" + left + " " + operator + " " + right + ")";
    }
}
