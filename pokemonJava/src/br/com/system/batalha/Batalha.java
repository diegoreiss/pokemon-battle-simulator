package br.com.system.batalha;

import br.com.exceptions.PokemonAbatidoException;
import br.com.system.pokemon.Movimento;
import br.com.system.pokemon.Pokemon;
import br.com.system.pokemon.Tipo;

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
}
