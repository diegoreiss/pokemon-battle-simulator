package br.com.system.treinador;

import br.com.system.mochila.Mochila;
import br.com.system.pokemon.Genero;
import br.com.system.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class TreinadorComum extends Treinador {

    private List<Insignia> insignias;

    public TreinadorComum(String nome, int idade, Genero genero, Mochila mochila) {
        super(nome, idade, genero, mochila);
        this.insignias = new ArrayList<>();
    }

    public TreinadorComum(String nome, int idade, Genero genero, Mochila mochila, Pokemon[] pokemons) {
        super(nome, idade, genero, mochila, pokemons);
        this.insignias = new ArrayList<>();
    }

    public List<Insignia> getInsignias() {
        return insignias;
    }

    public void setInsignias(List<Insignia> insignias) {
        this.insignias = insignias;
    }

    @Override
    public void mostrarCartao() {

    }
}
