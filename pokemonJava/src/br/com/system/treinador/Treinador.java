package br.com.system.treinador;

import br.com.system.mochila.Mochila;
import br.com.system.pokemon.Genero;
import br.com.system.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class Treinador {

    private String nome;
    private int idade;
    private Genero genero;
    private final int CAPACIDADE_DE_POKEMONS = 6;
    private Pokemon[] pokemons = new Pokemon[CAPACIDADE_DE_POKEMONS];
    private List<Insignia> insignias;
    private Mochila mochila;

    public Treinador(String nome, int idade, Genero genero, Mochila mochila) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.mochila = mochila;
        this.insignias = new ArrayList<>();
    }

    public Treinador(String nome, int idade, Genero genero, Mochila mochila, Pokemon[] pokemons) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.mochila = mochila;
        this.pokemons = isDentroDaCapacidade(pokemons) ? pokemons : slicePokemons(pokemons);
        this.insignias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getCAPACIDADE_DE_POKEMONS() {
        return CAPACIDADE_DE_POKEMONS;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public List<Insignia> getInsignias() {
        return insignias;
    }

    public void setInsignias(List<Insignia> insignias) {
        this.insignias = insignias;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
    }

    public void mostrarPokemon() {}

    public abstract void mostrarCartao();

    public void procurarPokemon() {}

    public  void curarPokemon() {}

    public void capturarPokemon() {}

    private boolean isDentroDaCapacidade(Pokemon[] pokemons) {
        return pokemons.length <= CAPACIDADE_DE_POKEMONS;
    }

    private Pokemon[] slicePokemons(Pokemon[] pokemons) {
        Pokemon[] pokemonsSliced = new Pokemon[CAPACIDADE_DE_POKEMONS];

        for (int i = 0; i < pokemonsSliced.length; i++) {
            pokemonsSliced[i] = pokemons[i];
        }

        return pokemonsSliced;
    }


}
