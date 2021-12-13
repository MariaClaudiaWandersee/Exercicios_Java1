package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Treinamento {

    int id;
    Date data;
    String detalhes;
    ArrayList<Golfinho> golfinho = new ArrayList<>();

    public Treinamento(int id,
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

    public void setGolfinho(Golfinho golfinho) {
        this.golfinho.add(golfinho);
    }

    public ArrayList<Golfinho> getGolfinho() {
        return this.golfinho;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Treinamento)) {
            return false;
        }
        Treinamento treinamento = (Treinamento) o;
        return treinamento.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getData());
    }

    @Override
    public String toString() {
        return "{" +
                " Leao ='" + getId() + "'" +
                " id ='" + getId() + "'" +
                "}";
    }
}