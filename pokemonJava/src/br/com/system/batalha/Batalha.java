package br.com.system.batalha;

import br.com.system.pokemon.Pokemon;
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

    private Pokemon[] copyArrayPokemon(Pokemon[] pokemons) {

        Pokemon[] copyArray = new Pokemon[pokemons.length];

        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = pokemons[i];
        }

        return copyArray;
    }

    private Pokemon[] removePrimeiroPokemon(Pokemon[] pokemons) {

        if (pokemons == null || pokemons.length == 0) {
            return pokemons;
        }

        int index = 0;

        Pokemon[] novoArrayPokemon = new Pokemon[pokemons.length - 1];

        for (int i = 0, j = 0; i < pokemons.length; i++) {
            if (i == index) {
                continue;
            }

            novoArrayPokemon[j++] = pokemons[i];
        }

        return  novoArrayPokemon;
    }
}
