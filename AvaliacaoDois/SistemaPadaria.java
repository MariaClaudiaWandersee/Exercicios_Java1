public class SistemaPadaria {
    public static void main(String[] args) {
    
    //Criação dos Objetos
    Chef chefUm = new Chef(154658, "Marcelo", "000.000.000-00" , "24/01/2002");
    Chef chefDois = new Chef(154589, "Gabriela", "000.000.000-00" , "15/05/2001");
    Chef chefTres = new Chef(154572, "Miguel", "000.000.000-00" , "09/12/1995");
    
    Padaria padariaUm = new Padaria(1, "Padaria do Seu Zé", "27/06/1991", 1, "89227-437", "Rua das Palmeiras", 999, "Jardim Paraíso", "Joinville");
    Padaria padariaDois = new Padaria(2, "Padaria Ana Braga", "14/08/2000", 2, "89222-679", "Rua dos Cedros", 666, "Iririu", "Joinville");
    Padaria padariaTres = new Padaria(3, "Padaria Kelson", "30/10/1980", 3, "89567-999", "Rua do Brigadeiro", 222, "Aventureiro", "Joinville");

    Receita receitaUm = new Receita(165987, "Miojo", "Colocar a água ferver, tirar o macarrão da embalagem e colocar o miojo na panela com água fervente. Após, retire da panela quando estiver no ponto mais macio, e sirva", 5);
    Receita receitaDois = new Receita(165987, "Frango Grelhado", "Pegue um peito de frango e tempere a gosto, em seguida leva uma frigideira ao fogo com um pouco de margarina ou manteiga, deixa ela derreter, e após adicione o frango a frigdeira. Doure ambos os lados e retire quando chegar no ponto em que você deseja.", 8);
    Receita receitaTres = new Receita(165987, "Batata Souté", "Pegue 10 batatas pequenas e descasque. Em uma panela com água fervente, adicone as batatas e uma pitada de sal, e deixe cozinhar por 10 minutos. Elas deveram ficar pré-cozinhdas. Em uma frigideira, derrata manteiga ou mararina e adicone as batatas e deixe dourar. Tempere com sal, pimenta e salpique salsa. ", 12);
    Receita receitaQuatro = new Receita(156257,"Quibe","Colocar o quibe pré-frito no air-fryer.",1);
    Receita receitaCinco = new Receita(158456,"Pão de Queijo","Colocar o pão de queijo pré-pronto no forno.",1);
    Receita receitaSeis = new Receita(147925,"Misto Quente","Passe a margarina em ambas as fatias de pão, recheie e coloque em uma assadeira",3);
    Receita receitaSete = new Receita(111555,"Pastel","Prepare a massa e o recheio, e coloque na fritadeira",3);
    Receita receitaOito = new Receita(147890,"Pão Frances","Prepare a massa e deixe assando no forno",9);
    Receita receitaNove = new Receita(154789,"Bolo de morango","Prepare a massa e deixe o bolo assando no forno",10);

    chefUm.adicionarReceita(receitaUm);
    chefUm.adicionarReceita(receitaDois);
    chefUm.adicionarReceita(receitaTres);

    chefDois.adicionarReceita(receitaQuatro);
    chefDois.adicionarReceita(receitaCinco);
    chefDois.adicionarReceita(receitaSeis);
    chefTres.adicionarReceita(receitaSete);
    chefTres.adicionarReceita(receitaOito);
    chefTres.adicionarReceita(receitaNove);

    System.out.println("Receitas do 1°chef Marcelo:");
        for (Receita receita : chefUm.receitas) {
            System.out.println(receita.nome);
        }
    System.out.println("\n");

    System.out.println("Receitas do 2°chef - Gabriela:");
        for (Receita receita : chefDois.receitas) {
            System.out.println(receita.nome);
        }
    System.out.println("\n");

    System.out.println("Receitas do 3°chef Miguel:");
        for (Receita receita : chefTres.receitas) {
            System.out.println(receita.nome);
        }
    System.out.println("\n");

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
            System.out.println(receita.nome);
        }

        System.out.println("\n Endereço:");
        System.out.println(
            " \n CEP: " + padariaUm.endereco.cep + 
            " \n Rua: "+ padariaUm.endereco.rua + 
            " \n Número: " + padariaUm.endereco.numero + 
            " \n Bairro: " + padariaUm.endereco.bairro + 
            " \n Cidade: " + padariaUm.endereco.cidade
        );

        System.out.println("\n");
        System.out.println("Padaria Ana Braga:");
        
        for (Receita receita : padariaDois.receitas) {
            System.out.println(receita.nome);
        }

        System.out.println("\n Endereço:");
        System.out.println(
            " \n CEP: " + padariaDois.endereco.cep + 
            " \n Rua: "+ padariaDois.endereco.rua + 
            " \n Número: " + padariaDois.endereco.numero + 
            " \n Bairro: " + padariaDois.endereco.bairro + 
            " \n Cidade: " + padariaDois.endereco.cidade
        );
        System.out.println("\n");
        System.out.println("Padaria Kelson:");
        
        for (Receita receita : padariaTres.receitas) {
            System.out.println(receita.nome);
        }

        System.out.println("\n Endereço:");
        System.out.println(
            " \n CEP: " + padariaTres.endereco.cep + 
            " \n Rua: "+ padariaTres.endereco.rua + 
            " \n Número: " + padariaTres.endereco.numero + 
            " \n Bairro: " + padariaTres.endereco.bairro + 
            " \n Cidade: " + padariaTres.endereco.cidade
        );
    }
}