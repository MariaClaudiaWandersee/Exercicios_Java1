package model;

import java.util.ArrayList;
import java.util.Objects;

public class Leao extends Animal {

    private int alimentacao;
    private int visitantes;
    protected Jaula jaula;
    private ArrayList<Alimentacao> alimentacoes = new ArrayList<>();

    public Leao(int id, String nome, int alimentacao, int visitantes, int idJaula, String descricao) {
        super(id, nome);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
        this.jaula = new Jaula(idJaula, descricao);
    }

    public void setAlimentacao(int alimentacao) {
        this.alimentacao = alimentacao;
    }

    public int getAlimentacao() {
        return this.alimentacao;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public int getVisitantes() {
        return this.visitantes;
    }

    public void setAlimentacao(Alimentacao alimentacao) {
        this.alimentacoes.add(alimentacao);
    }

    public ArrayList<Alimentacao> getAlimentacoes() {
        return this.alimentacoes;
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
        if (!(o instanceof Leao)) {
            return false;
        }
        Leao leao = (Leao) o;
        return Objects.equals(alimentacao, leao.visitantes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitantes);
    }

    @Override
    public String toString() {
        return "{" +
                "\n\n ID = '" + getId() + "'" +
                "\n\n NOME = '" + getNome() + "'" +
                "\n\n ALIMENTCAO = '" + getAlimentacao() + "'" +
                "\n\n VISITANTES = '" + getVisitantes() + "'" +
                "\n\n}";
    }

}