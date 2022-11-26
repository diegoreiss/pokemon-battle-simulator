package br.com.system.batalha;

import br.com.system.treinador.LiderDeGinasio;
import br.com.system.treinador.TreinadorComum;

public class Batalha {

    private TipoBatalha tipoBatalha;

    public Batalha(TipoBatalha tipoBatalha) {
        this.tipoBatalha = tipoBatalha;
    }

    public TipoBatalha getTipoBatalha() {
        return tipoBatalha;
    }

    public void setTipoBatalha(TipoBatalha tipoBatalha) {
        this.tipoBatalha = tipoBatalha;
    }
}
