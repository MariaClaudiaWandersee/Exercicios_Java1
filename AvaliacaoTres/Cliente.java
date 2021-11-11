package AvaliacaoTres;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Pessoa {
 
    private String telefone;
    ArrayList<Receita> receitas = new ArrayList<>();
 
    public Cliente(String nome, String cpf, String dataNascimento, String telefone) {
        super(nome, cpf, dataNascimento);
        this.telefone = telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return this.telefone;
    }

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);    
    }
 
    public void adicionarReceita(String id, String nome, String etapas, int numEtapas, String valor) {
        Receita receita = new Receita(id, nome, etapas, numEtapas, valor);
        this.receitas.add(receita);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefone);
    }

    @Override
    public String toString() {
        return "\n\n Cliente "
            + "\n\nNome: " + this.getNome()
            + "\nCPF: " + this.getCpf()
            + "\nData de Nascimento: " + this.getDataDeNascimento()
            + "\n Telefone: " + this.getTelefone();
    }
}