package br.com.system.treinador;

import br.com.system.mochila.Mochila;
import br.com.system.pokemon.Genero;
import br.com.system.pokemon.Pokemon;

public class LiderDeGinasio extends Treinador {

    private Ginasio ginasio;

    public LiderDeGinasio(String nome, int idade, Genero genero, Mochila mochila) {
        super(nome, idade, genero, mochila);
    }

    public LiderDeGinasio(String nome, int idade, Genero genero, Mochila mochila, Pokemon[] pokemons) {
        super(nome, idade, genero, mochila, pokemons);
    }

    public Ginasio getGinasio() {
        return ginasio;
    }

    public void setGinasio(Ginasio ginasio) {
        this.ginasio = ginasio;
    }

    @Override
    public void mostrarCartao() {

    }
}
