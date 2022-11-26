package br.com.system.pokemon;

import java.util.List;

public class Pokemon {

    private String nome;
    private int hpBase;
    private Genero genero;
    private List<Tipo> tipos;
    private Movimento[] movimentos = new Movimento[4];

    public Pokemon(String nome, int hpBase, Genero genero, List<Tipo> tipos) {
        this.nome = nome;
        this.hpBase = hpBase;
        this.genero = genero;
        this.tipos = tipos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHpBase() {
        return hpBase;
    }

    public void setHpBase(int hpBase) {
        this.hpBase = hpBase;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Movimento[] getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(Movimento[] movimentos) {
        this.movimentos = movimentos;
    }

    public void aprenderMovimento(Movimento movimento) {

        if (isMovimentosFull()) {
            System.err.printf("%s já atingiu o limite de movimentos!%n", this.nome);
        } else if (isAprendeuMovimento(movimento)){
            System.err.printf("%s já aprendeu esse movimento!%n", this.nome);
        } else {
            for (int i = 0; i < movimentos.length; i++) {

                if (movimentos[i] == null) {
                    movimentos[i] = movimento;
                    break;
                }
            }
        }
    }

    private boolean isMovimentosFull() {

        int contNotNull = 0;

        for (Movimento movimento : movimentos) {
            if (movimento != null) {
                contNotNull++;
            }
        }

        return contNotNull == movimentos.length;
    }

    private boolean isAprendeuMovimento(Movimento movimento) {

        boolean isAprendeu = false;

        for (Movimento mov : movimentos) {
            if (mov != null && mov.equals(movimento)) {
                isAprendeu = true;
                break;
            }
        }

        return isAprendeu;
    }
}
