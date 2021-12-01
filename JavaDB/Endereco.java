

import java.util.Objects;

public class Endereco {

    private String endereco;
    private String cep;
    private String rua;
    private int numero; 
    private String bairro;
    private String cidade;
    protected Estabelecimento estabelecimento;

    public Endereco(
        String endereco,
        String cep,
        String rua,
        int numero,
        String bairro,
        String cidade,
        Estabelecimento estabelecimento
    ) {
        this.endereco = endereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep, endereco.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep);
    }

    @Override
    public String toString() {
        return "\n" +
            "ID Endereço = '" + getEndereco() + "'" +
            "\nCEP = '" + getCep() + "'" +
            "\nRua = '" + getRua() + "'" +
            "\nNúmero = '" + getNumero() + "'" +
            "\nBairro = '" + getBairro() + "'" +
            "\nCidade = '" + getCidade() + "'" +
            "";
    }
}