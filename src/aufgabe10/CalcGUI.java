package aufgabe10;

import javax.swing.*;
import java.awt.*;

public class CalcGUI extends JFrame{

    public static void main(String[] args) {
        JFrame gui = new CalcGUI();
    }

    static final int w = 1000;
    static final int h = 900;

    // Konstruktor
    public CalcGUI(){
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(w, h));

        // Grobe Struktur
        JPanel in = new JPanel();
        JPanel form = new JPanel();
        JPanel op = new JPanel();
        JButton clear = new JButton("Clear");

        // Panel in
        JLabel lX = new JLabel("Operand x");
        JTextField tX = new JTextField();
        JLabel lY = new JLabel("Operand y");
        JTextField tY = new JTextField();
        JLabel lRes = new JLabel("Resultat");
        JTextField tRes = new JTextField();

        in.setLayout(new GridLayout(3, 2));
        in.add(lX);
        in.add(tX);
        in.add(lY);
        in.add(tY);
        in.add(lRes);
        in.add(tRes);

        // Panel form
        JCheckBox deg = new JCheckBox("Deg");
        JCheckBox rad = new JCheckBox("Rad");
        JCheckBox mode = new JCheckBox("Helles Display");
        mode.setSelected(true);

        form.add(deg);
        form.add(rad);
        form.add(mode);

        // Panel op
        JButton plus = new JButton("+");
        JButton mul = new JButton("*");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton sin = new JButton("sin");
        JButton cos = new JButton("cos");
        JButton pow = new JButton("pow");
        JButton log2 = new JButton("log2");

        op.setLayout(new GridLayout(2, 4));
        op.add(plus);
        op.add(mul);
        op.add(minus);
        op.add(divide);
        op.add(sin);
        op.add(cos);
        op.add(pow);
        op.add(log2);

        // GUI zusammenbasteln
        this.setLayout(new GridLayout(4, 1));
        this.add(in);
        this.add(form);
        this.add(op);
        this.add(clear);

        this.pack();
        this.setVisible(true);
    }
}
