package br.com.system.treinador;

import br.com.system.mochila.Mochila;
import br.com.system.pokemon.Genero;

public class LiderDeGinasio extends Treinador {

    private Ginasio ginasio;

    public LiderDeGinasio(String nome, int idade, Genero genero, Mochila mochila) {
        super(nome, idade, genero, mochila);
    }

    public Ginasio getGinasio() {
        return ginasio;
    }

    public void setGinasio(Ginasio ginasio) {
        this.ginasio = ginasio;
    }

    @Override
    public void mostrarCartao() {
        System.out.println("==============================");
        System.out.println("      CARTAO DE TREINADOR     ");
        System.out.println("==============================");
        System.out.println("NOME: " + getNome());
        System.out.println("Pokemons: ");
        mostrarPokemons();
        System.out.println("Pertence ao : " + ginasio.getNome());
        System.out.println("Entrega a : " + ginasio.getInsignia().getNome());
        System.out.println("==============================");
    }

    public void entregarInsignia(TreinadorComum treinadorComum) {
        Insignia insigniaParaEntregar = ginasio.getInsignia();

        try {
            treinadorComum.receberInsignia(insigniaParaEntregar);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
