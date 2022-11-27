package br.com.system.batalha;

import java.util.Random;

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

    public boolean fugirDaBatalha() throws Exception {

        if (this.tipoBatalha.equals(TipoBatalha.BATALHA_POKEMON_COM_TREINADOR)) {
            throw new Exception("Não pode fugir de uma batalha com treinador!");
        }

        boolean[] booleans = {true, false};

        int randomInt = new Random().nextInt(booleans.length);

        return booleans[randomInt];
    }

}
