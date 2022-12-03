package br.com.system.batalha;

import br.com.system.pokemon.Pokemon;

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
}
