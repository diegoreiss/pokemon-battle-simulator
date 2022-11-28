package br.com.system.pokemon;

public class Movimento {

    private String nome;
    private int danoBase;
    private String descricao;
    private Tipo tipo;

    public Movimento(String nome, int danoBase, String descricao, Tipo tipo) {
        this.nome = nome;
        this.danoBase = danoBase;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
