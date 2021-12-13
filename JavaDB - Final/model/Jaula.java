package model;

import java.util.Objects;

public class Jaula {

    private int id;
    private String descricao;

    public Jaula(int id,
                 String descricao) {
                     
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Jaula)) {
            return false;
        }
        Jaula jaula = (Jaula) o;
        return this.getId() == jaula.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getDescricao());
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'," +
                " descricao='" + getDescricao() + "'" +
                "}";
    }

}