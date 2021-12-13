package model;

import java.util.Objects;

public abstract class Animal {
    
    private int id;
    private String nome;

    protected Animal(int id,
                     String nome) {
        this.nome = nome;
        this.id = id;
    }

    protected String getNome() {
        return this.nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected int getId() {
        return this.id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
    }
        Animal animal = (Animal) o;
        return Objects.equals(nome, animal.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, id);
    }

    @Override
    public String toString() {
        return "{" +
                " Nome = '" + getNome() + "'" +
                " nId = '" + getId() + "'" + "}";
    }

}