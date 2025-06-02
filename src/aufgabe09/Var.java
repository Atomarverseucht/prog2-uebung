package aufgabe09;

public class Var implements Expression {

    final String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
