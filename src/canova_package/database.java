package canova_package;

import javax.swing.*;
import java.sql.*;

public class database {
    private Connection connessione;
    String nome;
    String host;
    String porta;

    public database(String host, String porta, String nome)  {
        this.host = host;
        this.porta = porta;
        this.nome = nome;
    }

    public String connessione(String username, String password){
        String c = "jdbc:mysql://"+host+":"+porta+"/"+nome;
        try {
            connessione = DriverManager.getConnection(c, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(connessione!=null)
            return "Connessione andata a buon fine!";
        return "Connessione fallita :(";
    }

    public void registrazione(String username, String password) {
        try {
            if(!connessione.isValid(5)){
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "INSERT INTO utenti VALUES(?,?)";
        PreparedStatement statement = null;
        try {
            statement = connessione.prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String username, String password){
        try {
            if(!connessione.isValid(5)){
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT username, password FROM utenti WHERE username = ? AND password = ?";
        PreparedStatement statement = null;
        try {
            statement = connessione.prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(
                        null,
                        "Accesso effettuato!",
                        "Login effettuato!",
                        JOptionPane.WARNING_MESSAGE
                );
                return true;
            }
            else{
                JOptionPane.showMessageDialog(
                        null,
                        "Accesso non effettuato :(",
                        "Login non effettuato :(",
                        JOptionPane.WARNING_MESSAGE
                );
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}