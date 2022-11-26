package br.com.system.treinador;

public class Insignia {

    private String nome;
    private String descricaoBase;
    private Ginasio ginasio;

    public Insignia(String nome, String descricaoBase, Ginasio ginasio) {
        this.nome = nome;
        this.descricaoBase = descricaoBase;
        this.ginasio = ginasio;
    }

    public Insignia(String nome, String descricaoBase) {
        this.nome = nome;
        this.descricaoBase = descricaoBase;
    }
}
