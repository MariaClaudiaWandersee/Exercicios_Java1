package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GolfinhoDB {
    public static void inserirGolfinho(Scanner scanner, Connection con) throws SQLException {

        int escolha = 0;
        int id = 0;
        String nome = "";
        int treinamento = 0;
        String descricao = "";
        System.out.println("\n\n - CRIAÇÃO DO GOLFINHO:");
        System.out.println("=================\n");
        System.out.printf("NOME: ");
        try {
            nome = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=================\n");
        System.out.printf("TREINAMENTO: ");
        try {
            treinamento = scanner.nextInt();
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
                "INSERT INTO golfinho (nome, treinamento, jaula_id) VALUES (?,?,?)",
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
            statement.setInt(2, treinamento);
            statement.setInt(3, idJaula);

            if (statement.executeUpdate() > 0) {
                ResultSet rsGolfinho = statement.getGeneratedKeys();
                rsGolfinho.next();
                int idGolfinho = rs.getInt(1);

                ResultSet sqlGolfinho = con.createStatement()
                        .executeQuery("SELECT * FROM golfinho WHERE id = " + idGolfinho);
                sqlGolfinho.next();
                System.out.println(
                        new Golfinho(
                                sqlGolfinho.getInt("id"),
                                sqlGolfinho.getString("nome"),
                                sqlGolfinho.getInt("treinamento"), idJaula, descricao));
            }
            System.out.println("CADASTRADO REALIZADO COM SUCESSSO!");
        }
    }

    public static void alterarGolfinho(Scanner scanner, Connection con) throws SQLException {
        int escolha = 0;
        int id = 0;
        String nome = "";
        int treinamento = 0;
        String descricao = "";

        System.out.println("\n\n - UPDATE DO GOLFINHO");
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
        System.out.printf("TREINAMENTO: ");
        try {
            treinamento = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PreparedStatement preparedStatement2 = con.prepareStatement(
                "UPDATE golfinho SET nome = ?, treinamento = ? WHERE id = ?",
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement2.setString(1, nome);
        preparedStatement2.setInt(2, treinamento);
        preparedStatement2.setInt(3, id);

        if (preparedStatement2.executeUpdate() <= 0) {
            System.out.println("Falha ao alterar o golfinho");
        }
    }

    public static void deletetarGolfinho(Scanner scanner, Connection con) throws SQLException {
        int escolha = 0;
        int id = 0;
        String nome = "";
        int treinamento = 0;
        String descricao = "";

        System.out.println("\n\n - DELETAR O GOLFINHO");
        System.out.println("");
        System.out.printf("ID: ");
        try {
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PreparedStatement preparedStatement3 = con.prepareStatement(
                "DELETE FROM golfinho WHERE id = ? ",
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement3.setInt(1, id);

        if (preparedStatement3.executeUpdate() <= 0) {
            System.out.println("Falha ao deletar o golfinho");
        }
    }

    public static void listarGolfinho(Scanner scanner, Connection con) throws SQLException {
        int escolha = 0;
        int id = 0;
        String nome = "";
        int treinamento = 0;
        String descricao = "";

        System.out.println("\n\n - SELECIONAR GOLFINHO:");
        System.out.printf("ID: ");
        try {
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM golfinho WHERE id = ? ",
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement4.setInt(1, id);
        ResultSet result = preparedStatement4.executeQuery();
        while (result.next()) {
            Golfinho golfinho = new Golfinho(
                    result.getInt("id"),
                    result.getString("nome"),
                    result.getInt("treinamento"),
                    result.getInt("jaula_id"), descricao);

            System.out.println(golfinho);
        }
    }
}