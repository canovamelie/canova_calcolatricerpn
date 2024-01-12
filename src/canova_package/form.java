package canova_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

public class form {
    private JPanel panelBase;
    private JTextField output;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn0;
    private JButton btnpaperta;
    private JButton btnpchiusa;
    private JButton btnpiu;
    private JButton btnmeno;
    private JButton btnper;
    private JButton btndiviso;
    private JButton btncanc;
    private JButton btnsubmit;
    private JTextField input;
    private JPanel pannel;

    void OnButtonClick(JButton b)
    {
        input.setText(input.getText()+b.getText());
    }
    public static void main() {
        JFrame frame = new JFrame("calcolatrice");
        frame.setContentPane(new form().panelBase);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    String conversioneRPN(String input) {
        String s = "";
        Stack<Character> stack = new Stack();
        char[] v1 = input.toCharArray();
        int v2 = v1.length;

        for (char c : v1) {
            if (Character.isDigit(c))
                s += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && (Character) stack.peek() != '(')
                    s += " " + String.valueOf(stack.pop());
                if (!stack.isEmpty() && (Character) stack.peek() == '(')
                    stack.pop();
            }
            else {
                if (!s.isEmpty() && s.charAt(s.length() - 1) != ' ')
                    s += " ";
                while (!stack.isEmpty() && this.comparazioneoperatori((Character) stack.peek(), c))
                    s += String.valueOf(stack.pop()) + " ";
                stack.push(c);
            }
        }
        while(!stack.isEmpty())
            s = s + " " + String.valueOf(stack.pop());

        return s;
    }

    float calcoloRPN(String input) {
        Stack<Float> stack = new Stack();
        String[] a = input.split("\\s+");
        String[] v1 = a;
        int v2 = a.length;

        for(int v3 = 0; v3 < v2; ++v3) {
            String s = v1[v3];
            float res = 0.0F;
            if (s.matches("\\d+"))
                stack.push(Float.parseFloat(s));
            else {
                float n2 = (Float)stack.pop();
                float n1 = (Float)stack.pop();
                if (s.equals("+"))
                    res = n1 + n2;
                else if (s.equals("-"))
                    res = n1 - n2;
                else if (!s.equals("/")) {
                    if (s.equals("*"))
                        res = n1 * n2;
                } else
                    res = n1 / n2;

                stack.push(res);
            }
        }
        return (Float)stack.pop();
    }

    int precedenzaoperatori(char c) {
        if (c != '*' && c != 215 && c != '/' && c != 247)
            return c != '+' && c != '-' ? 0 : 1;
        else
            return 2;
    }

    boolean comparazioneoperatori(char c1, char c2) {
        return this.precedenzaoperatori(c1) >= this.precedenzaoperatori(c2);
    }

    boolean isPostfix(String input) {
        char lastChar = input.charAt(input.length() - 1);
        return lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == 215 || lastChar == 247;
    }

    public form() {
        this.btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn0);
            }
        });
        this.btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn1);
            }
        });
        this.btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn2);
            }
        });
        this.btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn3);
            }
        });
        this.btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn4);
            }
        });
        this.btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn5);
            }
        });
        this.btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn6);
            }
        });
        this.btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn7);
            }
        });
        this.btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn8);
            }
        });
        this.btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btn9);
            }
        });
        this.btnpiu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btnpiu);
            }
        });
        this.btnmeno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btnmeno);
            }
        });
        this.btnper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btnper);
            }
        });
        this.btndiviso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btndiviso);
            }
        });
        this.btnpaperta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btnpaperta);
            }
        });
        this.btnpchiusa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btnpchiusa);
            }
        });
        this.btncanc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.this.OnButtonClick(form.this.btncanc);
            }
        });

        this.btnsubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String testoinput = form.this.input.getText();
                if (!testoinput.isBlank() && !testoinput.isEmpty()) {
                    if (form.this.isPostfix(testoinput))
                        form.this.output.setText(Float.toString(form.this.calcoloRPN(testoinput)));
                    else
                        form.this.output.setText(Float.toString(form.this.calcoloRPN(form.this.conversioneRPN(testoinput))));
                }
            }
        });
    }


}
