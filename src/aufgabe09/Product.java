package aufgabe09;

public class Product extends CompoundExpression {

    public Product(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public String toString(){
        return left + " * " + right;
    }
}
