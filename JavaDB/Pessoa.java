import java.sql.Date;
import java.util.Objects;

public class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private Date dataDeNascimento;

    protected Pessoa(String nome, String cpf, Date dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    protected Pessoa(int id, String nome, String cpf, Date dataDeNascimento) {
        this(nome, cpf, dataDeNascimento);
        this.id = id;
    }

    protected int getId() {
        return this.id;
    }

    protected void setId(int id) {
        this.id = id;
    }
    
    protected String getNome() {
        return this.nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return this.cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected Date getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    protected void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, dataDeNascimento);
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", dataDeNascimento='" + getDataDeNascimento() + "'" +
            "}";
    }
}