public class Pessoa {

    private String nome;
    private String cpf;
    private String dtNasci;
    protected String carteira;

    public Pessoa(String nome, String cpf, String dtNasci, String carteira) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasci = dtNasci;
        this.carteira = carteira;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDtNasci(String dtNasci) {
        this.dtNasci = dtNasci;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getDtNasci() {
        return this.dtNasci;
    }

    public String getCarteira() {
        return this.carteira;
    }
}