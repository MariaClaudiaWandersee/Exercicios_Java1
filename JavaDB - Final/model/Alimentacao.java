package model;

import java.sql.Date;
import java.util.Objects;

public class Alimentacao {

    private int id;
    private Date data;
    private String detalhes;
    private Leao leao;

    public Alimentacao(int id,
                       Date data,
                       String detalhes) {
        this.id = id;
        this.data = data;
        this.detalhes = detalhes;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDetalhes() {
        return this.detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Leao getLeao() {
        return this.leao;
    }

    public void setLeao(Leao leao) {
        this.leao = leao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alimentacao)) {
            return false;
        }
        Alimentacao alimentacao = (Alimentacao) o;
        return alimentacao.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getData());
    }

    @Override
    public String toString() {
        return "{" +
                " leao ='" + getLeao() + "'" +
                " id ='" + getId() + "'" +
                "}";
    }
}