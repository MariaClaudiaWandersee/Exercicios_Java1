/* Talvez será necessário adicionar o 'Carteira' como get e set*/
public class Medico extends Pessoa {

    private String crm;
    private String estado;
    protected String carteira;

    public Medico(String nome, String cpf, String dataNasci, String crm, String estado, String carteira) {
        super(nome, cpf, dataNasci, carteira);
        this.crm = crm;
        this.estado = estado;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCrm() {
        return this.crm;
    }

    public String getEstado() {
        return this.estado;
    }

    @Override
    public String toString() {
        return "\n\tMédico " + "\n\nNome = " + this.getNome() + "\nCPF = " + this.getCpf() + "\nData de Nascimento = "
                + this.getDtNasci() + "\n\nCarteira = " + this.getCarteira() + "\nEstado = " + this.getEstado()
                + "\nCrm = " + this.getCrm();
    }
}