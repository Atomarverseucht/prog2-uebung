package aufgabe11.aufgabe11_2;

import java.util.Map;
import java.util.Set;

public interface Expression {
    double eval(Map<String, Double> varBel);
    Set<String> getVars();
}
