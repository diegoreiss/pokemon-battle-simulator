package br.com.system.batalha;

import br.com.exceptions.PokemonAbatidoException;
import br.com.system.mochila.*;
import br.com.system.pokemon.Movimento;
import br.com.system.pokemon.Pokemon;
import br.com.system.pokemon.Tipo;

import java.sql.SQLOutput;
import java.util.Scanner;

public interface Batalha {
    static void mostrarInformacoesPokemons(Pokemon pokemonPlayer, Pokemon pokemonAdversario) {
        System.out.printf(
                "%n" +
                        "%s [%c] : %s%n" +
                        "   hp: %d/%d%n" +
                        "%s [%c] : %s%n" +
                        "   hp: %d/%d%n",
                pokemonAdversario.getNome(), pokemonAdversario.getSIMBOLO_GENERO(), pokemonAdversario.getTipos(),
                    pokemonAdversario.getHpAtual(), pokemonAdversario.getHP_TOTAL(),
                pokemonPlayer.getNome(), pokemonPlayer.getSIMBOLO_GENERO(), pokemonPlayer.getTipos(),
                    pokemonPlayer.getHpAtual(), pokemonPlayer.getHP_TOTAL()
        );
    }

    static void verificarHp(Pokemon pokemonQueRecebeuAtaque) throws PokemonAbatidoException {
        if (pokemonQueRecebeuAtaque.getHpAtual() <= 0) {
            throw new PokemonAbatidoException("Pokemon " + pokemonQueRecebeuAtaque.getNome() + " foi abatido!");
        }
    }

    static void atacarPokemon(Movimento movimentoEscolhido, Pokemon pokemonAReceberOMovimento) throws PokemonAbatidoException {
        int danoAReceber = danoAReceber(movimentoEscolhido, pokemonAReceberOMovimento);
        pokemonAReceberOMovimento.setHpAtual(pokemonAReceberOMovimento.getHpAtual() - danoAReceber);
        verificarHp(pokemonAReceberOMovimento);
    }

    static int danoAReceber(Movimento movimentoEscolhido, Pokemon pokemonAReceberOMovimento) {
        int danoAReceber = movimentoEscolhido.getDanoBase();

        for (Tipo tipo : pokemonAReceberOMovimento.getTipos()) {
            for (Tipo fraqueza : tipo.getFracoContra()) {
                if (fraqueza.equals(movimentoEscolhido.getTipo())) {
                    danoAReceber = movimentoEscolhido.getDanoBase() * 2;
                    System.out.println("Foi super efetivo!");
                    break;
                }
            }
        }

        return danoAReceber;
    }

    static Movimento escolherMovimentoPokemonPlayer(Pokemon pokemonPlayerAtual) {
        Scanner sc = new Scanner(System.in);

        int movimentoIndex = 1, movimentoEscolhidoIndex = 0;
        boolean loop = true;
        Movimento movimentoEscolhido = null;

        System.out.println("MOVIMENTOS");
        for (Movimento movimento : pokemonPlayerAtual.getMovimentos()) {
            System.out.printf("%d - %s : [%s]%n", movimentoIndex++, movimento.getNome(), movimento.getTipo().getNome());
        }

        do {
            try {
                System.out.println("Qual movimento escolher?: ");
                movimentoEscolhidoIndex = sc.nextInt();
                movimentoEscolhido = pokemonPlayerAtual.getMovimentos()[movimentoEscolhidoIndex-1];
                loop = false;
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        } while (loop);

        return movimentoEscolhido;
    }

    static int opcoesBatalha() {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        System.out.printf("\n" +
                "[1] - Lutar\n" +
                "[2] - Fugir\n" +
                "[3] - Mochila\n\n");

        do {
            System.out.print(">> ");
            opcao = sc.nextInt();
        } while (opcao < 1 || opcao > 3);

        return opcao;
    }

    static int opcoesMochila() {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        System.out.println("\n" +
                "[1] - Curar Pokemon\n" +
                "[2] - Capturar Pokemon\n\n");

        do {
            System.out.print(">> ");
            opcao = sc.nextInt();
        } while (opcao < 1 || opcao > 2);

        return opcao;
    }

    static Pocao escolherPocao(Mochila mochila) {
        Scanner sc = new Scanner(System.in);

        int itemPocaoIndex = 1, itemPocaoEscolhidoIndex = 0;
        boolean loop = true;
        Pocao pocaoEscolhida = null;

        System.out.println("POÇÕES");
        for (ItemPocao itemPocao : mochila.getPocoes()) {
            System.out.printf("[%d] - %s : x%d%n", itemPocaoIndex++, itemPocao.getPocao().getNome(), itemPocao.getQuantidade());
        }

        do {
            try {
                System.out.println("Qual poção escolher?: ");
                itemPocaoEscolhidoIndex = sc.nextInt();
                pocaoEscolhida = mochila.getPocoes().get(itemPocaoEscolhidoIndex-1).getPocao();
                loop = false;
            } catch (IndexOutOfBoundsException ignored) {}
        } while (loop);

        return pocaoEscolhida;
    }

    static Pokebola escolherPokebola(Mochila mochila) {
        Scanner sc = new Scanner(System.in);

        int itemPokebolaIndex = 1, itemPokebolaEscolhidaIndex = 0;
        boolean loop = true;
        Pokebola pokebolaEscolhida = null;

        System.out.println("POKEBOLAS");
        for (ItemPokebola itemPokebola : mochila.getPokebolas()) {
            System.out.printf("[%d] - %s : x%d%n", itemPokebolaIndex++, itemPokebola.getPokebola().getNome(), itemPokebola.getQuantidade());
        }

        do {
            try {
                System.out.println("Qual pokebola escolher?: ");
                itemPokebolaEscolhidaIndex = sc.nextInt();
                pokebolaEscolhida = mochila.getPokebolas().get(itemPokebolaEscolhidaIndex-1).getPokebola();
                loop = false;
            } catch (IndexOutOfBoundsException ignored) {}
        } while (loop);

        return pokebolaEscolhida;
    }

    static Pokemon[] copyArrayPokemon(Pokemon[] pokemons) {
        int contPokemons = 0;

        for (Pokemon pokemon : pokemons) {
            if (pokemon != null) {
                contPokemons++;
            }
        }

        Pokemon[] copyArray = new Pokemon[contPokemons];

        for (int i = 0; i < copyArray.length; i++) {
            if (pokemons[i] == null) {
                continue;
            }

            copyArray[i] = pokemons[i];
        }

        return copyArray;
    }

    static Pokemon[] removePrimeiroPokemon(Pokemon[] pokemons) {
        if (pokemons == null || pokemons.length == 0) {
            return pokemons;
        }

        int firstIndex = 0;

        Pokemon[] novoArrayPokemon = new Pokemon[pokemons.length-1];

        for (int i = 0, j = 0; i < pokemons.length; i++) {
            if (i == firstIndex) {
                continue;
            }

            novoArrayPokemon[j++] = pokemons[i];
        }

        return novoArrayPokemon;
    }
}
