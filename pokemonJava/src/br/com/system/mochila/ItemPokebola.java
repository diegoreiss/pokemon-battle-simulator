package br.com.system.mochila;

public class ItemPokebola {

    private int quantidade;
    private Pokebola pokebola;

    public ItemPokebola(int quantidade, Pokebola pokebola) {
        this.quantidade = quantidade;
        this.pokebola = pokebola;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pokebola getPokebola() {
        return pokebola;
    }

    public void setPokebola(Pokebola pokebola) {
        this.pokebola = pokebola;
    }
}
