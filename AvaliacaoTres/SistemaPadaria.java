
package Avaliacao;
public class SistemaPadaria {
    public static void main(String[] args) {
    
    //Criação dos Objetos
    Chef chefUm = new Chef("Marcelo", "000.000.000-00" , "24/01/2002", "Padeiro", "Bolos de Festa");
    Chef chefDois = new Chef("Gabriela", "000.000.000-00" , "15/05/2001", "Padeiro", "Salgados de Festa");
    Chef chefTres = new Chef("Miguel", "000.000.000-00" , "09/12/1995", "Padeiro", "Tortas");
    
    Cliente clienteUm = new Cliente("Junior Almeida","000.000.000-00","10/01/2000","3434-0102");
    Cliente clienteDois = new Cliente("Maria","000.000.000-00","08/12/1999","3346-0100");
    Cliente clienteTres = new Cliente("Marcelo","000.000.000-00","05/08/2002","9710-8447");

    Padaria padariaUm = new Padaria(1, "Padaria do Seu Zé", "27/06/1991", "08h às 18h", "Perto da Millium","89227-437","Rua das Palmeiras", 999, "Jardim Paraíso", "Joinville");
    Padaria padariaDois = new Padaria(2, "Padaria Ana Braga", "14/08/2000", "08h às 20h", "Ao lado do bar do seu Tadeu ","89222-679","Rua dos Cedros", 666, "Iririu", "Joinville");
    Padaria padariaTres = new Padaria(3, "Padaria Kelson", "30/10/1980", "09h às 22h", "Na esquina com a casa da Dona Maria","89567-999", "Rua do Brigadeiro", 222, "Aventureiro", "Joinville");

    Mercado mercadoUm = new Mercado(400,"Angeloni","01/01/1998","Carnes em promoção","1935","89204-080","Rua João Colin",2800,"Saguaçu","Joinville-SC");
    Mercado mercadoDois = new Mercado(500,"Giassi","06/08/1978","Refrigerantes em promoção","4002","89211-321","Rua Orestes Guimarães",315,"Centro","Joinville-SC");
    Mercado mercadoTres = new Mercado(600,"Condor","11/08/2000","Frutas em promoção","8922","89278-020","Rua Blumenau",715,"Atiradores","Joinville-SC");

    Receita receitaUm = new Receita("165987", "Miojo", "Colocar a água ferver, tirar o macarrão da embalagem e colocar o miojo na panela com água fervente. Após, retire da panela quando estiver no ponto mais macio, e sirva", 5, "R$5,00");
    Receita receitaDois = new Receita("165987", "Frango Grelhado", "Pegue um peito de frango e tempere a gosto, em seguida leva uma frigideira ao fogo com um pouco de margarina ou manteiga, deixa ela derreter, e após adicione o frango a frigdeira. Doure ambos os lados e retire quando chegar no ponto em que você deseja.", 8, "R$10,00");
    Receita receitaTres = new Receita("165987", "Batata Souté", "Pegue 10 batatas pequenas e descasque. Em uma panela com água fervente, adicone as batatas e uma pitada de sal, e deixe cozinhar por 10 minutos. Elas deveram ficar pré-cozinhdas. Em uma frigideira, derrata manteiga ou mararina e adicone as batatas e deixe dourar. Tempere com sal, pimenta e salpique salsa.",12, "R$20,90");
    Receita receitaQuatro = new Receita("156257","Quibe","Colocar o quibe pré-frito no air-fryer.",1, "R$4,50");
    Receita receitaCinco = new Receita("158456","Pão de Queijo","Colocar o pão de queijo pré-pronto no forno.",1, "R$2,00");
    Receita receitaSeis = new Receita("147925","Misto Quente","Passe a margarina em ambas as fatias de pão, recheie e coloque em uma assadeira",3, "R$4,75");
    Receita receitaSete = new Receita("111555","Pastel","Prepare a massa e o recheio, e coloque na fritadeira",3, "R$4,00");
    Receita receitaOito = new Receita("147890","Pão Frances","Prepare a massa e deixe assando no forno",9, "R$0.75");
    Receita receitaNove = new Receita("154789","Bolo de morango","Prepare a massa e deixe o bolo assando no forno",10, "R$12,00");
    Receita receitaDez = new Receita("154780","Suco natural de lanja","Corte as laranjas ao meio e esprema",3, "R$6,00");
    Receita receitaOnze = new Receita("155089","Suco verde","Pegue dois limões e algumas folhas de couve, coloque no liquidificador e coe.",5, "R$11,50");
    Receita receitaDoze = new Receita("150489","Bolo de chocolate","Prepare a massa e deixe o bolo assando no forno",10, "R$12,00");
    Receita receitaTreze = new Receita("150487","Bandeija de ovos","Escolha os ovos mais bonitos e coloque em uma bandeija",2, "R$12,00");
    Receita receitaQuatorze = new Receita("150784","Maça","Selecione as mais bonitas e leve a sacola",2, "R$5,50");
    Receita receitaQuinze = new Receita("158845","Banana Nanica","Selecione as mais bonitas e leve a sacola",2, "R$6,00");
    Receita receitaDezesseis = new Receita("158849","Morango","Selecione as mais bonitas e leve a sacola",2, "R$7,00");
    Receita receitaDezessete = new Receita("158876","Pão integral de forma","Prepare a massa e deixe assando no forno",10, "R$10,00");
    Receita receitaDezoito = new Receita("158899","Sanduíche gelado de presunto e queijo","Prepare o pão, corte duas fatias, e recheie",5, "R$4,75");

    chefUm.adicionarReceita(receitaUm);
    chefUm.adicionarReceita(receitaDois);
    chefUm.adicionarReceita(receitaTres);
    chefUm.adicionarReceita(receitaQuatro);
    chefUm.adicionarReceita(receitaCinco);
    chefUm.adicionarReceita(receitaSeis);
    
    chefDois.adicionarReceita(receitaSete);
    chefDois.adicionarReceita(receitaOito);
    chefDois.adicionarReceita(receitaNove);
    chefDois.adicionarReceita(receitaDez);
    chefDois.adicionarReceita(receitaOnze);
    chefDois.adicionarReceita(receitaDoze);

    chefTres.adicionarReceita(receitaTreze);
    chefTres.adicionarReceita(receitaQuatorze);
    chefTres.adicionarReceita(receitaQuinze);
    chefTres.adicionarReceita(receitaDezesseis);
    chefTres.adicionarReceita(receitaDezessete);
    chefTres.adicionarReceita(receitaDezoito);

    System.out.println("Receitas do 1°chef - Marcelo:");
        for (Receita receita : chefUm.receitas) {
            System.out.println(receita.nome);
        }
    System.out.println("\n");

    System.out.println("Receitas do 2°chef - Gabriela:");
        for (Receita receita : chefDois.receitas) {
            System.out.println(receita.nome);
        }
    System.out.println("\n");

    System.out.println("Receitas do 3°chef - Miguel:");
        for (Receita receita : chefTres.receitas) {
            System.out.println(receita.nome);
        }
    System.out.println("\n\n");

    clienteUm.adicionarReceita(receitaDois);
    clienteUm.adicionarReceita(receitaQuatro);
    clienteUm.adicionarReceita(receitaSeis);
    clienteUm.adicionarReceita(receitaOito);
    clienteUm.adicionarReceita(receitaDez);
    clienteUm.adicionarReceita(receitaDoze);
    clienteUm.adicionarReceita(receitaQuatorze);
    clienteUm.adicionarReceita(receitaDezesseis);
    clienteUm.adicionarReceita(receitaDezoito);
    clienteUm.adicionarReceita(receitaUm);

    clienteDois.adicionarReceita(receitaUm);
    clienteDois.adicionarReceita(receitaTres);
    clienteDois.adicionarReceita(receitaCinco);
    clienteDois.adicionarReceita(receitaSete);
    clienteDois.adicionarReceita(receitaNove);
    clienteDois.adicionarReceita(receitaOnze);
    clienteDois.adicionarReceita(receitaTreze);
    clienteDois.adicionarReceita(receitaQuinze);
    clienteDois.adicionarReceita(receitaDezessete);
    clienteDois.adicionarReceita(receitaDois);

    clienteTres.adicionarReceita(receitaUm);
    clienteTres.adicionarReceita(receitaDois);
    clienteTres.adicionarReceita(receitaTres);
    clienteTres.adicionarReceita(receitaQuatro);
    clienteTres.adicionarReceita(receitaCinco);
    clienteTres.adicionarReceita(receitaOnze);
    clienteTres.adicionarReceita(receitaDoze);
    clienteTres.adicionarReceita(receitaTreze);
    clienteTres.adicionarReceita(receitaQuatorze);
    clienteTres.adicionarReceita(receitaQuinze);
    System.out.println("\n\n");

    System.out.println("Receitas do 1° cliente:");
    for (Receita receita : clienteUm.receitas) {
        System.out.println(receita.nome + " - " + receita.valor);
    }
    System.out.println("\n\n");

    System.out.println("Receitas do 2° cliente:");
    for (Receita receita : clienteDois.receitas) {
        System.out.println(receita.nome + " - " + receita.valor);
    }
    System.out.println("\n\n");

    System.out.println("Receitas do 3° cliente:");
    for (Receita receita : clienteTres.receitas) {
        System.out.println(receita.nome + " - " + receita.valor);
    }
    System.out.println("\n\n");

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
    }
}