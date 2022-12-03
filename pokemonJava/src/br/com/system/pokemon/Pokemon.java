package br.com.system.pokemon;

import java.util.Arrays;
import java.util.List;

public class Pokemon {

    private String nome;
    private final int HP_TOTAL;
    private int hpAtual;
    private Genero genero;
    private final char SIMBOLO_GENERO;
    private Movimento[] movimentos = new Movimento[4];
    private List<Tipo> tipos;

    public Pokemon(String nome, int HP_TOTAL, Genero genero, List<Tipo> tipos) {
        this.nome = nome;
        this.HP_TOTAL = HP_TOTAL;
        this.hpAtual = this.HP_TOTAL;
        this.genero = genero;
        this.tipos = tipos;
        this.SIMBOLO_GENERO = (this.genero == Genero.MASCULINO) ? '\u2642' : '\u2640';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHP_TOTAL() {
        return HP_TOTAL;
    }

    public int getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(int hpAtual) {
        this.hpAtual = hpAtual;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public char getSIMBOLO_GENERO() {
        return SIMBOLO_GENERO;
    }

    public Movimento[] getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(Movimento[] movimentos) {
        this.movimentos = movimentos;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
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

    @Override
    public String toString() {
        return nome;
    }
}
