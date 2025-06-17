package aufgabe10;

// Klasse welche das Ergebnis berechnet
public abstract class Calculator {
    static double calculate(final double x, final double y, String cmd, boolean isRad){
        switch(cmd){
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y;
            case "x^y": return Math.pow(x, y);
            case "sin": return Math.sin(x);
            case "cos": return Math.cos(x);
            case "log2": return Math.log(x) / Math.log(2);
            default: throw new IllegalArgumentException("Command not found");
        }
    }
}
