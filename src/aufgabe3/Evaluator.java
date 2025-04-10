/*
 * class Evaluator
 * repl-Schleife: lese von der Konsole eine Ziele und 
 * werte sie als arithmetischen Ausdruck aus.
 *
 * O. Bittel; 22.03.2018
 * Verbeserung am 11.04.2018: +,-, *, / müssen linksassozoativ sein.
 * Geändert am 13.4.2018: da KEYWORS String-Konstante sind, 
 * reicht Gleichheitsprüfung mit ==.
 * 
 */
package aufgabe3;

import java.util.Arrays;
import java.util.Scanner;

import static aufgabe3.Tokenizer.*;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */

/**
 * Klasse zum Auswerten von arithmetischen Ausdrücken.
 */
public class Evaluator {

    private static final String ANSI_BLUE = "\u001B[34m";
    private Object[] stack;		    // Stack
    private int size;	    				// Index des obersten Kellerelements
    private Object token;					// Aktuelles Token
    private Tokenizer tokenizer;			// Zerlegt String-Eingabe in Tokens

    public Evaluator() {
        stack = new Object[20];
        size = 0;
    }


    /**
     * Wertet expr als arithmetischen Ausdruck aus.
     *
     * @param expr Arthmetischer Ausdruck als String
     * @return Wert des Ausdrucks oder null, falls der Ausdruck fehlerhaft ist.
     */
    public Double eval(String expr) {
        // Dollar in leeren Stack ablegen:
        size = 0;
        stack[size++] = DOLLAR;

        // expr in Tokens zerlegen und erstes Token abholen:
        tokenizer = new Tokenizer(expr);
        token = tokenizer.nextToken();

        while (token != null) {
            //System.out.println("token = " + token);
            if (shift()) { // Shift durchführen, falls möglich
                continue;
            } else if (reduce()) { // Reduce durchführen, falls möglich
                continue;
            } else if (accept()) { // prüfen ob Ausdruck erfolgreich evaluiert wurde
                return (Double) stack[size -1];
            } else {
                return null; // Fehler beim Auswerten
            }
        }
        return null; // Fehler beim Auswerten
    }

    private boolean shift() {
        if ((stack[size -1] == DOLLAR || isOp(stack[size-1]) || stack[size-1] == KL_AUF)
                && (token == KL_AUF || isVal(token))) {		                                    // Regel 1-3 der Parser-Tabelle
            doShift();
            return true;
        } else if(checkStackPattern("$v") && isOp(token)){                                      // Regel 6
            doShift();
            return true;
        } else if(checkStackPattern("(v") && (isOp(token) || token == KL_ZU)){                  // Regel 7
            doShift();
            return true;
        } else if(checkStackPattern("vov") && isOp(token)){
            if(compareOp((String) stack[size-2], (String)token) <= 0) {                         // Regel 9
                doShift();
                return true;
            } else{
                doReduceValOpVal();
                return true;
            }
        }
        else {
            return false;
        }
    }

    private void doShift() {
        // Ihr Code:
        addToStack(token);
        token = tokenizer.nextToken();
    }

    private boolean isOp(Object o) {
        return (o == PLUS || o == MULT || o == POWER);
    }

    private boolean isVal(Object o) {
        return o instanceof Double;
    }

    private boolean reduce() {
        if (size < 4) {
            return false;
        }

        if (stack[size - 3] == KL_AUF && isVal(stack[size - 2]) && stack[size -1] == KL_ZU
                && (token == KL_ZU || isOp(token) || token == DOLLAR)) {         // Regel 4 der Parser-Tabelle		(v)
            doReduceKlValKl();
            return true;
        } else if(checkStackPattern("vov") && (token == KL_ZU || token == DOLLAR)){ // Regel 8
            doReduceValOpVal();
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkStackPattern(String pattern){
        final int pSize = pattern.length();
        for (int i = 1; i <= pSize; i++) {
            Object s = stack[size-i];
            char p = pattern.charAt(pSize - i);
            if(p == 'v' && isVal(s)){
                continue;
            } else if(p == 'o' && isOp(s)){
                continue;
            } else if(!isVal(s) && ((String) s).charAt(0) == p){
                continue;
            } return false;
        }
        return true;
    }

    private void doReduceKlValKl() {
        // Ihr Code:
        stack[size-3] = stack[size-2];
        size -= 2;
    }

    private void doReduceValOpVal() {
        // Ihr Code:
        double solution;
        double v1 = (double) stack[size - 3];
        String op = (String) stack[size - 2];
        double v2 = (double) stack[size - 1];
        switch(op){
            case "+": solution = v1 + v2; break;
            case "*": solution = v1 * v2; break;
            case "^": solution = Math.pow(v1, v2); break;
            default: throw new IllegalArgumentException();
        }
        stack[size - 3] = solution;
        size -= 2;
    }

    private boolean accept() {
        // Ihr Code:
        if(checkStackPattern("$v") && token == DOLLAR){
            return true;
        }
        return false;
    }

    /**
     * Liest von der Konsole eine Folge von Zeilen, wertet jede Zeile als
     * Ausdruck aus und gibt seinen Wert aus. (repl = read-evaluate-print-loop).
     */
    public void repl() {
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_BLUE + ">> ");

        while (in.hasNextLine()) {
            String line = in.nextLine();
            // Ihr Code:
            System.out.println(eval(line));
            System.out.print(ANSI_BLUE + ">> ");
        }
    }

    public static int compareOp(String op1, String op2){
        int[] opV = new int[2];
        String[] op = new String[2];
        op[0] = op1;
        op[1] = op2;
        for (int i = 0; i < op.length; i++) {
            switch(op[i]){
                case "^": opV[i] = 2; break;
                case "*": opV[i] = 1; break;
                case "+": opV[i] = 0; break;
                default: throw new IllegalArgumentException();
            }
        }
        return (opV[0] - opV[1]);
    }

    public void addToStack(Object in){
        if(size == stack.length){
            stack = Arrays.copyOf(stack, 2*size);
        }
        stack[size] = in;
        size++;
    }
    /**
     * Testprogramm.
     *
     * @param args wird nicht benutzt.
     */
    public static void main(String[] args) {
        // Zum Testen, später auskommentieren:
		String s1 = "1+2";
		String s2 = "2^10+5";
		String s3 = "5+2^10";
        String s4 = "(2+3*4+4)^2";
        String s5 = "(2+3*4+4))*2";
        String s6 = "2+3**4";
        String s7 = "2^2^3";
        String s8 = "2^2*5";
        String s9 = "1+(2+(3+(4+(5+6))))";
        String s10 = "1+2+3+4+5+6";

        Evaluator evaluator = new Evaluator();

		System.out.println(evaluator.eval(s1));	// 3.0
		System.out.println(evaluator.eval(s2));	// 1029.0
        System.out.println(evaluator.eval(s3));	// 1029.0
        System.out.println(evaluator.eval(s4));	// 324.0
        System.out.println(evaluator.eval(s5));	// null; Syntaxfehler
        System.out.println(evaluator.eval(s6));	// null; Syntaxfehler
        System.out.println(evaluator.eval(s7));	// 256.0
        System.out.println(evaluator.eval(s8));	// 20.0
        System.out.println(evaluator.eval(s9));	// 21.0
        System.out.println(evaluator.eval(s10)); // 21.0

        evaluator.repl();
    }
}
