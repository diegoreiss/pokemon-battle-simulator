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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoBase() {
        return descricaoBase;
    }

    public void setDescricaoBase(String descricaoBase) {
        this.descricaoBase = descricaoBase;
    }

    public Ginasio getGinasio() {
        return ginasio;
    }

    public void setGinasio(Ginasio ginasio) {
        this.ginasio = ginasio;
    }
}
