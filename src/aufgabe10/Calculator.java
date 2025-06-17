package aufgabe10;

// Klasse welche das Ergebnis berechnet
public final class Calculator {
    static double calculate(final double x, final double y, String cmd, boolean isDeg){
        return switch (cmd) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            case "x^y" -> Math.pow(x, y);
            case "sin" -> Math.sin(degToRad(x, isDeg));
            case "cos" -> Math.cos(degToRad(x, isDeg));
            case "log2" -> Math.log(x) / Math.log(2);
            default -> throw new IllegalArgumentException("Command not found");
        };
    }

    static double degToRad(double x, boolean isDeg){
        return isDeg ? Math.toRadians(x) : x;
    }
}
