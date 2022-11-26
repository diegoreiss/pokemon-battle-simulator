package br.com.system.mochila;

public class Pokebola {

    private String nome;
    private double percentualCaptura;

    public Pokebola(String nome, double percentualCaptura) {
        this.nome = nome;
        this.percentualCaptura = percentualCaptura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPercentualCaptura() {
        return percentualCaptura;
    }

    public void setPercentualCaptura(double percentualCaptura) {
        this.percentualCaptura = percentualCaptura;
    }
}
