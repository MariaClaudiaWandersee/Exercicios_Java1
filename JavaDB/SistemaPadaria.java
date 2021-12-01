
//Ps: em alguns arquivos decidi tirar os 'Private' de alguns arrays, pois estava dando erro no SistemaPadaria.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;

public class SistemaPadaria {
    public static void main(String[] args) {
        try {
            final String url = "jdbc:mysql://localhost:3306/JavaDB?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            Scanner scan = new Scanner(System.in);
            int escolhaPrincipal = 0;
            int escolhaChef = 0;
            int escolhaCliente = 0;
            int id = 0;
            String nome = "";
            String cpf = "";
            String dataNascimento = "";
            String cargo = "";
            String especialidade = "";
            String telefone = "";

            do {
                System.out.println("\t=================");
                System.out.println("\t MENU ");
                System.out.println("\t=================");
                System.out.println(" [1] - Imprimir CHEF com Prepared Statement");
                System.out.println(" [2] - Imprimir CLIENTE com Prepared Statement");
                System.out.println(" [3] - Imprimir o Sistema Padaria todo");
                System.out.println(" [4] - SAIR ");
                System.out.printf(" Sua escolha é: ");
                escolhaPrincipal = scan.nextInt();
                switch (escolhaPrincipal) {

                    case 1:
                        System.out.println("\n\n - CHEF com Prepared Statement - ");
                        do {
                            System.out.println("\t=================");
                            System.out.println("\t MENU ");
                            System.out.println("\t=================");
                            System.out.println(" [1] - INSERT CHEF com Prepared Statement");
                            System.out.println(" [2] - UPDATE CHEF com Prepared Statement");
                            System.out.println(" [3] - DELETE CHEF com Prepared Statement");
                            System.out.println(" [4] - SELECT CHEF com Prepared Statement");
                            System.out.println(" [5] - SAIR ");
                            System.out.printf(" Sua escolha é: ");
                            escolhaChef = scan.nextInt();
                            switch (escolhaChef) {

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

                                    ResultSet rs = con.createStatement()
                                            .executeQuery("SELECT * FROM Chef WHERE IdChef = " + id);
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

                                case 5:
                                    System.out.println("\n\n Obrigado por usar o programa! ");
                                    break;
                            }
                        } while (escolhaChef != 5);
                        break;

                    case 2:
                        try {
                            do {
                                System.out.println("\t=================");
                                System.out.println("\t MENU ");
                                System.out.println("\t=================");
                                System.out.println(" [1] - INSERT CLIENTE com Prepared Statement");
                                System.out.println(" [2] - UPDATE CLIENTE com Prepared Statement");
                                System.out.println(" [3] - DELETE CLIENTE com Prepared Statement");
                                System.out.println(" [4] - SELECT CLIENTE com Prepared Statement");
                                System.out.println(" [5] - SAIR ");
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
                        break;

                    case 3:             
                                        //Clientes
                                        Connection conn = DriverManager.getConnection(url, user, password);
                                        PreparedStatement preparedStatement4 = con.prepareStatement(
                                                "SELECT * FROM Cliente");
                                        ResultSet result = preparedStatement4.executeQuery();
                                        while (result.next()) {
                                            System.out.printf(" - Impressão dos Clientes ");
                                            Cliente cliente = new Cliente(
                                                result.getInt("IdCliente"),
                                                result.getString("nome"),
                                                result.getString("cpf"),
                                                result.getDate("dataNascimento"),
                                                result.getString("telefone"));
                                            System.out.println(cliente);
                                        }
                                        System.out.printf(" \n");

                                        //Chefs
                                        //Connection conne = DriverManager.getConnection(url, user, password);
                                        PreparedStatement preparedStatement5 = con.prepareStatement(
                                                "SELECT * FROM Chef");
                                    
                                        ResultSet resultS = preparedStatement5.executeQuery();
                                        while (result.next()) {
                                            System.out.printf(" - Impressão dos Chefs ");
                                            Chef chef = new Chef(
                                                result.getInt("IdChef"),
                                                result.getString("nome"),
                                                result.getString("cpf"),
                                                result.getDate("dataNascimento"),
                                                result.getString("cargo"),
                                                result.getString("especialidade"));
                                            System.out.println(chef);
                                        }
                                        System.out.printf(" \n");

                        Padaria padariaUm = new Padaria(1, "Padaria do Seu Zé", "27/06/1991",
                                "08h às 18h", "Perto da Millium", "89227-437",
                                "Rua das Palmeiras", 999, "Jardim Paraíso", "Joinville");
                        Padaria padariaDois = new Padaria(2, "Padaria Ana Braga", "14/08/2000",
                                "08h às 20h",
                                "Ao lado do bar do seu Tadeu ", "89222-679", "Rua dos Cedros", 666, "Iririu",
                                "Joinville");
                        Padaria padariaTres = new Padaria(3, "Padaria Kelson", "30/10/1980",
                                "09h às 22h",
                                "Na esquina com a casa da Dona Maria", "89567-999", "Rua do Brigadeiro", 222,
                                "Aventureiro", "Joinville");

                        Mercado mercadoUm = new Mercado(400, "Angeloni", "01/01/1998",
                                "Carnes em promoção", "1935", "89204-080",
                                "Rua João Colin", 2800, "Saguaçu", "Joinville-SC");
                        Mercado mercadoDois = new Mercado(500, "Giassi", "06/08/1978",
                                "Refrigerantes em promoção", "4002", "89211-321",
                                "Rua Orestes Guimarães", 315, "Centro", "Joinville-SC");
                        Mercado mercadoTres = new Mercado(600, "Condor", "11/08/2000",
                                "Frutas em promoção", "8922", "89278-020",
                                "Rua Blumenau", 715, "Atiradores", "Joinville-SC");

                        Receita receitaUm = new Receita("165987", "Miojo",
                                "Colocar a água ferver, tirar o macarrão da embalagem e colocar o miojo na panela com água fervente. Após, retire da panela quando estiver no ponto mais macio, e sirva",
                                5, "R$5,00");
                        Receita receitaDois = new Receita("165987", "Frango Grelhado",
                                "Pegue um peito de frango e tempere a gosto, em seguida leva uma frigideira ao fogo com um pouco de margarina ou manteiga, deixa ela derreter, e após adicione o frango a frigdeira. Doure ambos os lados e retire quando chegar no ponto em que você deseja.",
                                8, "R$10,00");
                        Receita receitaTres = new Receita("165987", "Batata Souté",
                                "Pegue 10 batatas pequenas e descasque. Em uma panela com água fervente, adicone as batatas e uma pitada de sal, e deixe cozinhar por 10 minutos. Elas deveram ficar pré-cozinhdas. Em uma frigideira, derrata manteiga ou mararina e adicone as batatas e deixe dourar. Tempere com sal, pimenta e salpique salsa.",
                                12, "R$20,90");
                        Receita receitaQuatro = new Receita("156257", "Quibe",
                                "Colocar o quibe pré-frito no air-fryer.", 1, "R$4,50");
                        Receita receitaCinco = new Receita("158456", "Pão de Queijo",
                                "Colocar o pão de queijo pré-pronto no forno.", 1,
                                "R$2,00");
                        Receita receitaSeis = new Receita("147925", "Misto Quente",
                                "Passe a margarina em ambas as fatias de pão, recheie e coloque em uma assadeira", 3,
                                "R$4,75");
                        Receita receitaSete = new Receita("111555", "Pastel",
                                "Prepare a massa e o recheio, e coloque na fritadeira", 3,
                                "R$4,00");
                        Receita receitaOito = new Receita("147890", "Pão Frances",
                                "Prepare a massa e deixe assando no forno", 9, "R$0.75");
                        Receita receitaNove = new Receita("154789", "Bolo de morango",
                                "Prepare a massa e deixe o bolo assando no forno",
                                10, "R$12,00");
                        Receita receitaDez = new Receita("154780", "Suco natural de lanja",
                                "Corte as laranjas ao meio e esprema", 3,
                                "R$6,00");
                        Receita receitaOnze = new Receita("155089", "Suco verde",
                                "Pegue dois limões e algumas folhas de couve, coloque no liquidificador e coe.", 5,
                                "R$11,50");
                        Receita receitaDoze = new Receita("150489", "Bolo de chocolate",
                                "Prepare a massa e deixe o bolo assando no forno",
                                10, "R$12,00");
                        Receita receitaTreze = new Receita("150487", "Bandeija de ovos",
                                "Escolha os ovos mais bonitos e coloque em uma bandeija", 2, "R$12,00");
                        Receita receitaQuatorze = new Receita("150784", "Maça",
                                "Selecione as mais bonitas e leve a sacola", 2, "R$5,50");
                        Receita receitaQuinze = new Receita("158845", "Banana Nanica",
                                "Selecione as mais bonitas e leve a sacola", 2,
                                "R$6,00");
                        Receita receitaDezesseis = new Receita("158849", "Morango",
                                "Selecione as mais bonitas e leve a sacola", 2,
                                "R$7,00");
                        Receita receitaDezessete = new Receita("158876", "Pão integral de forma",
                                "Prepare a massa e deixe assando no forno", 10, "R$10,00");
                        Receita receitaDezoito = new Receita("158899",
                                "Sanduíche gelado de presunto e queijo",
                                "Prepare o pão, corte duas fatias, e recheie", 5, "R$4,75");

                        padariaUm.adicionarReceita(receitaUm);
                        padariaUm.adicionarReceita(receitaDois);
                        padariaUm.adicionarReceita(receitaTres);
                        padariaUm.adicionarReceita(receitaQuatro);
                        padariaUm.adicionarReceita(receitaCinco);

                        padariaDois.adicionarReceita(receitaQuatro);
                        padariaDois.adicionarReceita(receitaCinco);
                        padariaDois.adicionarReceita(receitaSeis);
                        padariaDois.adicionarReceita(receitaSete);
                        padariaDois.adicionarReceita(receitaOito);

                        padariaTres.adicionarReceita(receitaOito);
                        padariaTres.adicionarReceita(receitaNove);
                        padariaTres.adicionarReceita(receitaUm);
                        padariaTres.adicionarReceita(receitaDois);
                        padariaTres.adicionarReceita(receitaTres);

                        System.out.println("\n Padaria do Seu Zé:");
                        for (Receita receita : padariaUm.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }

                        System.out.println("\n");
                        System.out.println("Padaria Ana Braga:");

                        for (Receita receita : padariaDois.receitas) {
                            System.out.println(receita.nome);
                        }

                        System.out.println("\n");
                        System.out.println("Padaria Kelson:");

                        for (Receita receita : padariaTres.receitas) {
                            System.out.println(receita.nome);
                        }

                        mercadoUm.adicionarReceita(receitaDez);
                        mercadoUm.adicionarReceita(receitaOnze);
                        mercadoUm.adicionarReceita(receitaDoze);
                        mercadoUm.adicionarReceita(receitaTreze);
                        mercadoUm.adicionarReceita(receitaQuatorze);

                        mercadoDois.adicionarReceita(receitaQuinze);
                        mercadoDois.adicionarReceita(receitaDezesseis);
                        mercadoDois.adicionarReceita(receitaDezessete);
                        mercadoDois.adicionarReceita(receitaDezoito);
                        mercadoDois.adicionarReceita(receitaQuatorze);

                        mercadoTres.adicionarReceita(receitaDezesseis);
                        mercadoTres.adicionarReceita(receitaOnze);
                        mercadoTres.adicionarReceita(receitaTreze);
                        mercadoTres.adicionarReceita(receitaDezoito);
                        mercadoTres.adicionarReceita(receitaQuatorze);

                        System.out.println("\n Receitas do 1° mercado:");
                        for (Receita receita : mercadoUm.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }
                        System.out.println("\n\n");

                        System.out.println("\n Receitas do 2° mercado:");
                        for (Receita receita : mercadoDois.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }
                        System.out.println("\n\n");

                        System.out.println("\n Receitas do 3° mercado:");
                        for (Receita receita : mercadoTres.receitas) {
                            System.out.println(receita.nome + " - " + receita.valor);
                        }
                        System.out.println("\n");
                        break;

                    case 4:
                        System.out.println("\n\n Obrigado por usar o programa! ");
                        break;
                }
            } while (escolhaPrincipal != 4);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
