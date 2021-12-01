import java.sql.Date; //Para converter de String para date
import java.util.ArrayList;
//import java.util.Objects;
//import Avaliacao.Pessoa;

public class Chef extends Pessoa {
 
    private String cargo;
    private String especialidade;
    ArrayList<Receita> receitas = new ArrayList<>();
 
    public Chef(String nome, String cpf, Date dataNascimento, String cargo, String especialidade) {
        super(nome, cpf, dataNascimento);
        this.cargo = cargo;
        this.especialidade = especialidade;
    }
    
    public Chef(int id, String nome, String cpf, Date dataNascimento, String cargo, String especialidade) {
        super(id, nome, cpf, dataNascimento);
        this.cargo = cargo;
        this.especialidade = especialidade;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCargo() {
        return this.cargo;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getEspecialidade() {
        return this.especialidade;
    }

     /* ---------------- RELACIONAMENTO ---------------- */
     
    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);    
    }
 
    public void adicionarReceita(String id, String nome, String etapas, int numEtapas, String valor) {
        Receita receita = new Receita(id, nome, etapas, numEtapas, valor);
        this.receitas.add(receita);
    }

    @Override
    public String toString() {
        return "\n\n Chef "
            + "\n\nNome: " + this.getNome()
            + "\nCPF: " + this.getCpf()
            + "\nData de Nascimento: " + this.getDataDeNascimento()
            + "\n Cargo: " + this.getCargo()
            + "\n Especialidade: " + this.getEspecialidade();
    }
}