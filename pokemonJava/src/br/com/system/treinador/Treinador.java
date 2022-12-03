package br.com.system.treinador;

import br.com.system.mochila.Mochila;
import br.com.system.mochila.Pocao;
import br.com.system.pokemon.Genero;
import br.com.system.pokemon.Pokemon;

public abstract class Treinador {
    private String nome;
    private int idade;
    private Genero genero;
    private final int CAPACIDADE_DE_POKEMONS = 6;
    private Pokemon[] pokemons = new Pokemon[CAPACIDADE_DE_POKEMONS];
    private Mochila mochila;

    public Treinador(String nome, int idade, Genero genero, Mochila mochila) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.mochila = mochila;
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

    public Mochila getMochila() {
        return mochila;
    }

    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
    }

    public abstract void mostrarCartao();

    public void mostrarPokemons() {
        for (Pokemon pokemon : this.pokemons) {
            try {
                System.out.printf("     %s [%c]%n", pokemon.getNome(), pokemon.getSIMBOLO_GENERO());
            } catch (NullPointerException nullPointerException) {
                break;
            }
        }
    }

    public void curarPokemon(Pocao pocao, Pokemon pokemonParaCurar) {
        pokemonParaCurar.setHpAtual(pokemonParaCurar.getHpAtual() + pocao.getHpRecupera());

        if (pokemonParaCurar.getHpAtual() >= pokemonParaCurar.getHP_TOTAL()) {
            pokemonParaCurar.setHpAtual(pokemonParaCurar.getHP_TOTAL());
        }

        mochila.removerItem(pocao, 1);
        System.out.printf("Curou o %s%n", pokemonParaCurar.getNome());
    }

    private boolean isCapacidadeFull() {
        int contNotNull = 0;

        for (Pokemon pokemon : this.pokemons) {
            if (pokemon != null) {
                contNotNull++;
            }
        }

        return contNotNull == this.CAPACIDADE_DE_POKEMONS;
    }
}
