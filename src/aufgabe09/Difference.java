package aufgabe09;

public class Difference extends CompoundExpression {

    public Difference(Expression e1, Expression e2){
        super(e1, e2);
    }

    @Override
    public String toString(){
        return left + " - " + right;
    }
}
