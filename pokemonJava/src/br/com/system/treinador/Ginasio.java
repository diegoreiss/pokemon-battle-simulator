package br.com.system.treinador;

public class Ginasio {

    private String nome;
    private Insignia insignia;
    private LiderDeGinasio doador;

    public Ginasio(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Insignia getInsignia() {
        return insignia;
    }

    public void setInsignia(Insignia insignia) {
        this.insignia = insignia;
    }

    public LiderDeGinasio getDoador() {
        return doador;
    }

    public void setDoador(LiderDeGinasio doador) {
        this.doador = doador;
    }
}
