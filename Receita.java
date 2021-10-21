import java.util.ArrayList;

public class Receita {

    int id;
    String nome;
    String etapas;
    int numEtapas;
    ArrayList<Padaria> padaria = new ArrayList<>();

    // início do construtor
    public Receita(
        Integer id,
        String nome,
        String etapas,
        int numEtapas
    ) {
        this.id = id;
        this.nome = nome;
        this.etapas = etapas;
        this.numEtapas = numEtapas;
    }
    // fim do construtor
    
    public void adicionarPadaria(Padaria padaria) {
        this.padaria.add(padaria);
    }
}