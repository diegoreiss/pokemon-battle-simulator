package br.com.system.mochila;

public class ItemPocao {

    private int quantidade;
    private Pocao pocao;

    public ItemPocao(int quantidade, Pocao pocao) {
        this.quantidade = quantidade;
        this.pocao = pocao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pocao getPocao() {
        return pocao;
    }

    public void setPocao(Pocao pocao) {
        this.pocao = pocao;
    }
}
