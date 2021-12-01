import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;

public class ChefPS {
    public static void main(String[] args) {
        try {
            final String url = "jdbc:mysql://localhost:3306/JavaDB?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner scan = new Scanner(System.in);
            int escolha = 0;
            int id = 0;
            String nome = "";
            String cpf = "";
            String dataNascimento = "";
            String cargo = "";
            String especialidade = "";

            do {
                System.out.println("\t=================");
                System.out.println("\t MENU ");
                System.out.println("\t=================");
                System.out.println(" [1] - INSERT CHEF com Prepared Statement");
                System.out.println(" [2] - UPDATE CHEF com Prepared Statement");
                System.out.println(" [3] - DELETE CHEF com Prepared Statement");
                System.out.println(" [4] - SELECT CHEF com Prepared Statement");
                System.out.println(" [5] - Imprimir todo o Sistema Padaria");
                System.out.println(" [6] - SAIR ");
                System.out.printf(" Sua escolha é: ");
                escolha = scan.nextInt();
                switch (escolha) {

                    case 1:
                        System.out.println("\n\n - CRIAÇÃO DE CHEF");
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
                        System.out.printf("CARGO: ");
                        try {
                            cargo = scan.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("ESPECIALIDADE: ");
                        try {
                            especialidade = scan.next();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        PreparedStatement preparedStatement = con.prepareStatement(
                                "INSERT INTO Chef (IdChef, nome, cpf, dataNascimento, cargo, especialidade) VALUES (?,?,?,?,?,?)",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement.setInt(1, id);
                        preparedStatement.setString(2, nome);
                        preparedStatement.setString(3, cpf);
                        preparedStatement.setString(4, dataNascimento);
                        preparedStatement.setString(5, cargo);
                        preparedStatement.setString(6, especialidade);

                        if (preparedStatement.executeUpdate() > 0) {
                            ResultSet resultado = preparedStatement.getGeneratedKeys();

                            if (resultado.next()) {
                                resultado.getInt(1);
                                resultado.getString(2);
                                resultado.getString(3);
                                resultado.getString(4);
                                resultado.getString(5);
                                resultado.getString(6);
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

                        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Chef WHERE IdChef = " + id);
                        Chef chefToUpdate;
                        if (rs.next()) {
                            chefToUpdate = new Chef(
                                    rs.getInt("IdChef"),
                                    rs.getString("Nome"),
                                    rs.getString("cpf"),
                                    rs.getDate("dataNascimento"),
                                    rs.getString("cargo"),
                                    rs.getString("especialidade"));
                        } else {
                            System.out.println("Valor do ID inválido");
                            break;
                        }

                        System.out.println("=================\n");
                        System.out.printf("NOME: ");
                        try {
                            nome = scan.next();
                            if (!nome.isEmpty()) {
                                chefToUpdate.setNome(nome);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("CPF: ");
                        try {
                            cpf = scan.next();
                            if (!cpf.isEmpty()) {
                                chefToUpdate.setCpf(cpf);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("DATA DE NASCIMENTO: ");
                        try {
                            dataNascimento = scan.next();
                            if (!dataNascimento.isEmpty()) {
                                chefToUpdate.setDataDeNascimento(Date.valueOf(dataNascimento));
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("CARGO: ");
                        try {
                            cargo = scan.next();
                            if (!cargo.isEmpty()) {
                                chefToUpdate.setCargo(cargo);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("=================\n");
                        System.out.printf("ESPECIALIDADE: ");
                        try {
                            especialidade = scan.next();
                            if (!especialidade.isEmpty()) {
                                chefToUpdate.setEspecialidade(especialidade);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        PreparedStatement preparedStatement2 = con.prepareStatement(
                                "UPDATE Chef SET Nome = ?, cpf = ?, dataNascimento = ?, cargo = ?, especialidade = ?  WHERE IdChef = ?",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement2.setString(1, chefToUpdate.getNome());
                        preparedStatement2.setString(2, chefToUpdate.getCpf());
                        preparedStatement2.setDate(3, chefToUpdate.getDataDeNascimento());
                        preparedStatement2.setString(4, chefToUpdate.getCargo());
                        preparedStatement2.setString(5, chefToUpdate.getEspecialidade());
                        preparedStatement2.setInt(6, chefToUpdate.getId());
                        if (preparedStatement2.executeUpdate() <= 0) {
                            System.out.println("Falha ao alterar o Chef");
                        }
                        break;

                    case 3:
                        System.out.println("\n\n - DELETAR CHEF");
                        System.out.println("");
                        System.out.printf("ID: ");
                        try {
                            id = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        PreparedStatement preparedStatement3 = con.prepareStatement(
                                "DELETE FROM Chef WHERE IdChef = ? ",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement3.setInt(1, id);
                        if (preparedStatement3.executeUpdate() <= 0) {
                            System.out.println("Falha ao deletar o Chef");
                        }
                        break;

                    case 4:
                        System.out.println("\n\n - SELECIONAR CHEF");
                        System.out.printf("ID: ");
                        try {
                            id = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        PreparedStatement preparedStatement4 = con.prepareStatement(
                                "SELECT * FROM Chef WHERE IdChef = ? ",
                                PreparedStatement.RETURN_GENERATED_KEYS);
                        preparedStatement4.setInt(1, id);
                        ResultSet result = preparedStatement4.executeQuery();
                        while (result.next()) {
                            Chef chef = new Chef(
                                    result.getInt("IdChef"),
                                    result.getString("nome"),
                                    result.getString("cpf"),
                                    result.getDate("dataNascimento"),
                                    result.getString("cargo"),
                                    result.getString("especialidade"));
                            System.out.println(chef);
                        }
                        break;

                    case 6:
                        System.out.println("\n\n Obrigado por usar o programa! ");
                        break;
                }
            } while (escolha != 6);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}