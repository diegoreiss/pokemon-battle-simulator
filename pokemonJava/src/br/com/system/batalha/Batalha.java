package br.com.system.batalha;

import br.com.exceptions.PokemonAbatidoException;
import br.com.system.pokemon.Movimento;
import br.com.system.pokemon.Pokemon;
import br.com.system.pokemon.Tipo;

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

        return movimentoEscolhido
    }
}
