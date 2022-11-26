package br.com.system.pokemon;

import java.util.ArrayList;
import java.util.List;

public class Tipo {

    private String nome;
    private List<Tipo> forteContra;
    private List<Tipo> fracoContra;

    public Tipo(String nome) {
        this.nome = nome;
        this.forteContra = new ArrayList<>();
        this.fracoContra = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tipo> getForteContra() {
        return forteContra;
    }

    public void setForteContra(List<Tipo> forteContra) {
        this.forteContra = forteContra;
    }

    public List<Tipo> getFracoContra() {
        return fracoContra;
    }

    public void setFracoContra(List<Tipo> fracoContra) {
        this.fracoContra = fracoContra;
    }
}
