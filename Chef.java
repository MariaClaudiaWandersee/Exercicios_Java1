import java.util.ArrayList;

public class Chef {

    int id;
    String nome;
    String cpf;
    String dataNasci;
    ArrayList<Receita> receitas = new ArrayList<>();

    // início do construtor
    public Chef(
        int id,
        String nome,
        String cpf,
        String dataNasci
    ) { 
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasci = dataNasci;
    }
    // fim do construtor 

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
    }

    public void adicionarReceita(
        int id,
        String nome,
        String etapas,
        int numEtapas
    ) {
        Receita receita = new Receita(id, nome, etapas, numEtapas);
        this.receitas.add(receita);
    }
}