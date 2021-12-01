import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//import java.sql.Date;

public class ClientePS {
    public static void main(String[] args) {
        try {
            final String url = "jdbc:mysql://localhost:3306/JavaDB?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner scan = new Scanner(System.in);
            int escolhaCliente = 0;
            int id = 0;
            String nome = "";
            String cpf = "";
            String dataNascimento = "";
            String telefone = "";

            do {
                System.out.println("\t=================");
                System.out.println("\t MENU ");
                System.out.println("\t=================");
                System.out.println(" [1] - INSERT CLIENTE com Prepared Statement");
                System.out.println(" [2] - UPDATE CLIENTE com Prepared Statement");
                System.out.println(" [3] - DELETE CLIENTE com Prepared Statement");
                System.out.println(" [4] - SELECT CLIENTE com Prepared Statement");
                System.out.println(" [5] - Imprimir todo o Sistema Padaria");
                System.out.println(" [6] - SAIR ");
                System.out.printf(" Sua escolha é: ");
                escolhaCliente = scan.nextInt();
                switch (escolhaCliente) {

                    case 1:
                        System.out.println("\n\n - CRIAÇÃO DE CLIENTE");
                        System.out.printf("ID: ");
                        try {
                            id = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("NOME: ");
                        try {
                            nome = scan.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("CPF: ");
                        try {
                            cpf = scan.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("DATA DE NASCIMENTO: ");
                        try {
                            dataNascimento = scan.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("TELEFONE: ");
                        try {
                            telefone = scan.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        PreparedStatement preparedStatement = con.prepareStatement(
                                "INSERT INTO Cliente (IdCliente, nome, cpf, dataNascimento, telefone) VALUES (?,?,?,?,?)",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement.setInt(1, id);
                        preparedStatement.setString(2, nome);
                        preparedStatement.setString(3, cpf);
                        preparedStatement.setString(4, dataNascimento);
                        preparedStatement.setString(5, telefone);

                        if (preparedStatement.executeUpdate() > 0) {
                            ResultSet resultado = preparedStatement.getGeneratedKeys();

                            if (resultado.next()) {
                                resultado.getInt(1);
                                resultado.getString(2);
                                resultado.getString(3);
                                resultado.getString(4);
                                resultado.getString(5);
                            }
                        }
                        break;

                    case 2:
                        System.out.println("\n\n - UPDATE DE DADOS");
                        System.out.printf("ID: ");
                        try {
                            id = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        ResultSet rs = con.createStatement()
                                .executeQuery("SELECT * FROM Cliente WHERE IdCliente = " + id);
                        Cliente clienteToUpdate;
                        if (rs.next()) {
                            clienteToUpdate = new Cliente(
                                    rs.getInt("IdCliente"),
                                    rs.getString("Nome"),
                                    rs.getString("cpf"),
                                    rs.getDate("dataNascimento"),
                                    rs.getString("telefone"));
                        } else {
                            System.out.println("Valor do ID inválido");
                            break;
                        }

                        System.out.println("=================\n");
                        System.out.printf("NOME: ");
                        try {
                            nome = scan.next();
                            if (!nome.isEmpty()) {
                                clienteToUpdate.setNome(nome);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("CPF: ");
                        try {
                            cpf = scan.next();
                            if (!cpf.isEmpty()) {
                                clienteToUpdate.setCpf(cpf);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("DATA DE NASCIMENTO: ");
                        try {
                            dataNascimento = scan.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("TELEFONE: ");
                        try {
                            telefone = scan.next();
                            if (!telefone.isEmpty()) {
                                clienteToUpdate.setTelefone(telefone);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        PreparedStatement preparedStatement2 = con.prepareStatement(
                                "UPDATE Chef SET Nome = ?, cpf = ?, dataNascimento = ?, cargo = ?, especialidade = ?  WHERE IdChef = ?",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement2.setString(1, clienteToUpdate.getNome());
                        preparedStatement2.setString(2, clienteToUpdate.getCpf());
                        preparedStatement2.setDate(3, clienteToUpdate.getDataDeNascimento());
                        preparedStatement2.setString(5, clienteToUpdate.getTelefone());
                        preparedStatement2.setInt(6, clienteToUpdate.getId());
                        if (preparedStatement2.executeUpdate() <= 0) {
                            System.out.println("Falha ao alterar o Cliente");
                        }
                        break;

                    case 3:
                        System.out.println("\n\n - DELETAR CLIENTE");
                        System.out.println("");
                        System.out.printf("ID: ");
                        try {
                            id = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        PreparedStatement preparedStatement3 = con.prepareStatement(
                                "DELETE FROM Cliente WHERE IdCliente = ? ",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement3.setInt(1, id);
                        if (preparedStatement3.executeUpdate() <= 0) {
                            System.out.println("Falha ao deletar o Cliente");
                        }
                        break;

                    case 4:
                        System.out.println("\n\n - SELECIONAR CLIENTE");
                        System.out.printf("ID: ");
                        try {
                            id = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        PreparedStatement preparedStatement4 = con.prepareStatement(
                                "SELECT * FROM Cliente WHERE IdCliente = ? ",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement4.setInt(1, id);
                        ResultSet result = preparedStatement4.executeQuery();
                        while (result.next()) {
                            Cliente cliente = new Cliente(
                                    result.getInt("IdCliente"),
                                    result.getString("nome"),
                                    result.getString("cpf"),
                                    result.getDate("dataNascimento"),
                                    result.getString("telefone"));
                            System.out.println(cliente);
                        }
                        break;

                    case 6:
                        System.out.println("\n\n Obrigado por usar o programa! ");
                        break;
                }
            } while (escolhaCliente != 6);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}