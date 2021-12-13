package view;

import javax.swing.*;

import model.GolfinhoBanco;
import model.LeaoBanco;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class TelaPrincipal extends JFrame {

    JButton button1 = new JButton("ADICIONAR LEÃO");
    JButton button2 = new JButton("ALTERAR LEÃO");
    JButton button3 = new JButton("DELETAR LEÃO");
    JButton button4 = new JButton("SELECIONAR LEÃO");

    JButton button5 = new JButton("ADICIONAR GOLFINHO");
    JButton button6 = new JButton("ALTERAR GOLFINHO");
    JButton button7 = new JButton("DELETAR GOLFINHO");
    JButton button8 = new JButton("SELECIONAR GOLFINHO");

    public TelaPrincipal() {

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(button1);
        pane.add(button2);
        pane.add(button3);
        pane.add(button4);
        pane.add(button5);
        pane.add(button6);
        pane.add(button7);
        pane.add(button8);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);

        // Leao

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonAlterarLeao(e);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttondeletarLeao(e);
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonlistarLeao(e);
            }
        });

        // Golfinho

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttoninserirGolfinho(e);
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonalterarGolfinho(e);
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttondeletetarGolfinho(e);
            }
        });

        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonlistarGolfinho(e);
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
            LeaoBanco.inserirLeao(scanner, con);
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
            LeaoBanco.alterarLeao(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO ALTERAR LEÃO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    private void buttondeletarLeao(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            LeaoBanco.deletetarLeao(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO DELETAR LEÃO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    private void buttonlistarLeao(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            LeaoBanco.listarLeao(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO SELECIONAR LEÃO!", "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    private void buttoninserirGolfinho(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            GolfinhoBanco.inserirGolfinho(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO CADASTRAR GOLFINHO!", "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    private void buttonalterarGolfinho(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            GolfinhoBanco.alterarGolfinho(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO ALTERAR GOLFINHO!", "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    private void buttondeletetarGolfinho(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            GolfinhoBanco.deletetarGolfinho(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO DELETAR GOLFINHO!", "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    private void buttonlistarGolfinho(ActionEvent e) {
        final String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            GolfinhoBanco.listarGolfinho(scanner, con);
            con.close();
            JOptionPane.showMessageDialog(this, "SUCESSO AO LISTAR GOLFINHO!", "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Erro: " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        TelaPrincipal janela = new TelaPrincipal();
    }
}