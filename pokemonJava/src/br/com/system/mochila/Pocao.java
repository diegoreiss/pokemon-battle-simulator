package br.com.system.mochila;

public class Pocao {

    private String nome;
    private int hpRecupera;

    public Pocao(String nome, int hpRecupera) {
        this.nome = nome;
        this.hpRecupera = hpRecupera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHpRecupera() {
        return hpRecupera;
    }

    public void setHpRecupera(int hpRecupera) {
        this.hpRecupera = hpRecupera;
    }
}
