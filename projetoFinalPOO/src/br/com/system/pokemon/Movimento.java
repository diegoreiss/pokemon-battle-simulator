package br.com.system.pokemon;

public class Movimento {

    private String nome;
    private int danoBase;
    private String descricao;
    private Tipo tipo;
    private int pontosPoder;

    public Movimento(String nome, int danoBase, String descricao, Tipo tipo, int pontosPoder) {
        this.nome = nome;
        this.danoBase = danoBase;
        this.descricao = descricao;
        this.tipo = tipo;
        this.pontosPoder = pontosPoder;
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

    public int getPontosPoder() {
        return pontosPoder;
    }

    public void setPontosPoder(int pontosPoder) {
        this.pontosPoder = pontosPoder;
    }
}
