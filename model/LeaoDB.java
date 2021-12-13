package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LeaoDB {
    public static void inserirLeao(Scanner scanner, Connection con) throws SQLException {
        String nome = "";
        int alimentacao = 0;
        int visitantes = 0;
        String descricao = "";
        System.out.println("\n\n - CRIAÇÃO DO LEÃO:");
        System.out.println("=================\n");
        System.out.printf("NOME: ");
        try {
            nome = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================\n");
        System.out.printf("ALIMENTACAO: ");
        try {
            alimentacao = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================\n");
        System.out.printf("VISITANTES: ");
        try {
            visitantes = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================\n");
        System.out.printf("DESCRIÇÃO DA JAULA: ");
        try {
            descricao = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PreparedStatement statement = con.prepareStatement(
                "INSERT INTO leao (nome, alimentacao, visitantes, jaula_id) VALUES (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

        PreparedStatement pStatement = con.prepareStatement(
                "INSERT INTO jaula (descricao) VALUES (?);",
                PreparedStatement.RETURN_GENERATED_KEYS);

        pStatement.setString(1, descricao);
        if (pStatement.executeUpdate() > 0) {
            ResultSet rs = pStatement.getGeneratedKeys();
            rs.next();
            int idJaula = rs.getInt(1);

            statement.setString(1, nome);
            statement.setInt(2, alimentacao);
            statement.setInt(3, visitantes);
            statement.setInt(4, idJaula);

            if (statement.executeUpdate() > 0) {
                ResultSet rsLeao = statement.getGeneratedKeys();
                rsLeao.next();
                int idLeao = rsLeao.getInt(1);

                ResultSet sqlLeao = con.createStatement().executeQuery("SELECT * FROM leao WHERE id = " + idLeao);
                sqlLeao.next();
                System.out.println(
                        new Leao(
                                sqlLeao.getInt("id"),
                                sqlLeao.getString("nome"),
                                sqlLeao.getInt("alimentacao"),
                                sqlLeao.getInt("visitantes"), idJaula, descricao));
            }
        }
        System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
    }

    public static void alterarLeao(Scanner scanner, Connection con) throws SQLException {
        int id = 0;
        String nome = "";
        int alimentacao = 0;
        int visitantes = 0;
        System.out.println("\n\n - UPDATE DO LEÃO");
        System.out.printf("ID: ");
        try {
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================\n");
        System.out.printf("NOME: ");
        try {
            nome = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================\n");
        System.out.printf("ALIMENTACAO: ");
        try {
            alimentacao = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================\n");
        System.out.printf("VISITANTES: ");
        try {
            visitantes = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PreparedStatement preparedStatement2 = con.prepareStatement(
                "UPDATE leao SET nome = ?, alimentacao = ?, visitantes = ? WHERE id = ?",
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement2.setString(1, nome);
        preparedStatement2.setInt(2, alimentacao);
        preparedStatement2.setInt(3, visitantes);
        preparedStatement2.setInt(4, id);

        if (preparedStatement2.executeUpdate() <= 0) {
            System.out.println("Falha ao alterar o leão");
        }
    }

    public static void deletetarLeao(Scanner scanner, Connection con) throws SQLException {
        int id = 0;
        System.out.println("\n\n - DELETAR O LEÃO");
        System.out.println("");
        System.out.printf("ID: ");
        try {
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PreparedStatement preparedStatement3 = con.prepareStatement(
                "DELETE FROM leao WHERE id = ? ",
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement3.setInt(1, id);

        if (preparedStatement3.executeUpdate() <= 0) {
            System.out.println("Falha ao deletar o leão");
        }
    }

    public static void listarLeao(Scanner scanner, Connection con) throws SQLException {
        int id = 0;
        System.out.println("\n\n - SELECIONAR LEÃO:");
        System.out.printf("ID: ");
        try {
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PreparedStatement preparedStatement4 = con.prepareStatement(
                "SELECT "
                        + "leao.id, "
                        + "leao.nome, "
                        + "leao.alimentacao, "
                        + "leao.visitantes, "
                        + "leao.jaula_id, "
                        + "jaula.descricao "
                        + "FROM leao "
                        + "INNER JOIN jaula "
                        + "ON jaula.id = leao.jaula_id "
                        + "WHERE id = ? ",
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement4.setInt(1, id);
        ResultSet result = preparedStatement4.executeQuery();
        while (result.next()) {
            Leao leao = new Leao(
                    result.getInt("id"),
                    result.getString("nome"),
                    result.getInt("alimentacao"),
                    result.getInt("visitantes"),
                    result.getInt("jaula_id"),
                    result.getString("descricao"));

            System.out.println(leao);
        }
    }
}