package br.com.system.treinador;

import br.com.system.mochila.Mochila;
import br.com.system.pokemon.Genero;
import br.com.system.pokemon.Pokemon;

public class TreinadorComum extends Treinador {

    public TreinadorComum(String nome, int idade, Genero genero, Mochila mochila) {
        super(nome, idade, genero, mochila);
    }

    public TreinadorComum(String nome, int idade, Genero genero, Mochila mochila, Pokemon[] pokemons) {
        super(nome, idade, genero, mochila, pokemons);
    }

    @Override
    public void mostrarCartao() {

    }
}
