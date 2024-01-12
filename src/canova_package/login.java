package canova_package;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    private JPanel login;
    private JTextField username;
    private JPasswordField password;
    private JButton btnaccesso;
    private JButton btnregistra;

    public login() {
        database db = new database("127.0.0.1", "3306", "calcolatrice");

        btnaccesso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                String psw = password.getText();
                if(db.login(user,psw))
                    openCalculatorForm();
            }
        });

        btnregistra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                String psw = password.getText();
                db.registrazione(user, psw);
                openCalculatorForm();
            }
        });
    }

    private void openCalculatorForm(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(login);
        if (frame != null)
            frame.setVisible(false);
        form.main();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("login");
        frame.setContentPane(new login().login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
