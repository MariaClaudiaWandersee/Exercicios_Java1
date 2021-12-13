package view;

import javax.swing.*;
import model.LeaoDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class LeaoTela extends JFrame {

    JButton button1 = new JButton("ADICIONAR LEAO");

    public LeaoTela() {

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(button1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(150, 200);
        this.setVisible(true);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
    }

    private void button1ActionPerformed(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            LeaoDB.inserirLeao(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO CADASTRAR LEÃO!", "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    private void buttonAlterarLeao(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            LeaoDB.alterarLeao(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO ALTERAR LEAO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        LeaoTela janela = new LeaoTela();
    }
}