package model;

import java.util.Objects;

public class Golfinho extends Animal {

    private int treinamento;
    protected Jaula jaula;

    public Golfinho(int id, String nome, int treinamento, int idJaula, String descricao) {
        super(id, nome);
        this.treinamento = treinamento;
        this.jaula = new Jaula(idJaula, descricao);
    }

    public int getTreinamento() {
        return this.treinamento;
    }

    public void setTreinamento(int treinamento) {
        this.treinamento = treinamento;
    }

    public Jaula getJaula() {
        return this.jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Golfinho)) {
            return false;
        }
        Golfinho golfinho = (Golfinho) o;
        return this.getId() == golfinho.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getNome());
    }

    @Override
    public String toString() {
        return "{" +
                "\n\n ID  = '" + getId() + "'" +
                "\n\n NOME  = '" + getNome() + "'" +
                "\n\n TREINAMENTO = '" + getTreinamento() + "'" +
                "\n\n}";
    }
}