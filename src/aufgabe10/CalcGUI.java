package aufgabe10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class CalcGUI extends JFrame implements ActionListener {

    public static void main(String[] args) {
        JFrame gui = new CalcGUI();
    }

    // Konstanten
    static final int w = 1000;
    static final int h = 900;

    // Buttons
    JButton plus = new JButton("+");
    JButton mul = new JButton("*");
    JButton minus = new JButton("-");
    JButton divide = new JButton("/");
    JButton sin = new JButton("sin");
    JButton cos = new JButton("cos");
    JButton pow = new JButton("x^y");
    JButton log2 = new JButton("log2");

    // Textboxen & Labels
    JLabel lX = new JLabel("Operand x");
    JTextField tX = new JTextField("0");
    JLabel lY = new JLabel("Operand y");
    JTextField tY = new JTextField("0");
    JLabel lRes = new JLabel("Resultat");
    JTextField tRes = new JTextField();

    // Sonstiges
    JRadioButton deg = new JRadioButton("Deg", true);
    JRadioButton rad = new JRadioButton("Rad");
    JCheckBox mode = new JCheckBox("Helles Display", true);

    // Initializes the GUI
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
        in.setLayout(new GridLayout(3, 2));
        in.add(lX);
        in.add(tX);
        in.add(lY);
        in.add(tY);
        in.add(lRes);
        in.add(tRes);

        // Panel form
        form.add(deg);
        form.add(rad);
        form.add(mode);

        // Panel op - Buttons s

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

        // ActionListener
        plus.addActionListener(this);
        minus.addActionListener(this);
        mul.addActionListener(this);
        divide.addActionListener(this);
        sin.addActionListener(this);
        cos.addActionListener(this);
        pow.addActionListener(this);
        log2.addActionListener(this);
        clear.addActionListener(this);
        rad.addActionListener(this);
        deg.addActionListener(this);
        mode.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            String cmd = e.getActionCommand();
            final double y;
            switch(cmd){
                case "Clear":
                    tX.setText(""); tY.setText(""); tRes.setText(""); return;
                case "Rad":
                    deg.setSelected(!rad.isSelected()); return;
                case "Deg":
                    rad.setSelected(!deg.isSelected()); return;
                case "Helles Display":
                    // Hier dsrkmode und so
                    return;
                case "sin", "cos", "log2":
                    y = 0;
                    tY.setText("");
                    break;
                case "+", "-", "*", "/", "x^y":
                    y = Double.parseDouble(tY.getText());
                    break;
                default:
                    System.out.println(cmd);
                    return;
            }
            tRes.setText(String.format("%.6f", Calculator.calculate(Double.parseDouble(tX.getText()), y, cmd, deg.isSelected())));

        } catch(NumberFormatException nfe){
            tRes.setText("Fehler: ZahlenEingabe");
        }
    }
}
