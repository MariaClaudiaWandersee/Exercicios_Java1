/* Talvez será necessário adicionar o 'Carteira' como get e set*/
public class Paciente extends Pessoa {

    protected int registro;
    protected String carteira;

    public Paciente(int registro, String nome, String cpf, String dtNasci, String carteira) {
        super(nome, cpf, dtNasci, carteira);
        this.registro = registro;
    }

    public void setregistro(int registro) {
        this.registro = registro;
    }

    public int getregistro() {
        return this.registro;
    }

    @Override
    public String toString() {
        return "\n\tPaciente " + "\n\nNome = " + this.getNome() + "\nCPF = " + this.getCpf() + "\nData de Nascimento = "
                + this.getDtNasci() + "\n\nCarteira = " + this.getCarteira() + "\nRegistro = " + this.getregistro();
    }
}