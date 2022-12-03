package br.com.system.batalha;

import br.com.exceptions.CapturaPokemonException;
import br.com.exceptions.FugirDaBatalhaException;
import br.com.exceptions.PokemonAbatidoException;
import br.com.system.mochila.Pocao;
import br.com.system.pokemon.Movimento;
import br.com.system.pokemon.Pokemon;
import br.com.system.treinador.TreinadorComum;

import java.util.Random;

public class BatalhaVsTreinadorComum implements Batalha {

    private TreinadorComum player;
    private TreinadorComum adversario;
    private Pokemon[] pokemonsPlayer;
    private Pokemon[] pokemonsAdversario;
    private Pokemon pokemonPlayerEscolhido;
    private Pokemon pokemonAdversarioEscolhido;

    public BatalhaVsTreinadorComum(TreinadorComum player, TreinadorComum adversario) {
        this.player = player;
        this.adversario = adversario;
        this.pokemonsPlayer = Batalha.copyArrayPokemon(this.player.getPokemons());
        this.pokemonsAdversario = Batalha.copyArrayPokemon(this.adversario.getPokemons());
        this.pokemonPlayerEscolhido = this.pokemonsPlayer[0];
        this.pokemonAdversarioEscolhido = this.pokemonsAdversario[0];
    }

    public TreinadorComum getPlayer() {
        return player;
    }

    public void setPlayer(TreinadorComum player) {
        this.player = player;
    }

    public TreinadorComum getAdversario() {
        return adversario;
    }

    public void setAdversario(TreinadorComum adversario) {
        this.adversario = adversario;
    }

    public Pokemon[] getPokemonsPlayer() {
        return pokemonsPlayer;
    }

    public void setPokemonsPlayer(Pokemon[] pokemonsPlayer) {
        this.pokemonsPlayer = pokemonsPlayer;
    }

    public Pokemon[] getPokemonsAdversario() {
        return pokemonsAdversario;
    }

    public void setPokemonsAdversario(Pokemon[] pokemonsAdversario) {
        this.pokemonsAdversario = pokemonsAdversario;
    }

    public Pokemon getPokemonPlayerEscolhido() {
        return pokemonPlayerEscolhido;
    }

    public void setPokemonPlayerEscolhido(Pokemon pokemonPlayerEscolhido) {
        this.pokemonPlayerEscolhido = pokemonPlayerEscolhido;
    }

    public Pokemon getPokemonAdversarioEscolhido() {
        return pokemonAdversarioEscolhido;
    }

    public void setPokemonAdversarioEscolhido(Pokemon pokemonAdversarioEscolhido) {
        this.pokemonAdversarioEscolhido = pokemonAdversarioEscolhido;
    }

    @Override
    public void iniciarBatalha() {
        System.out.println("Foi desafiado pelo treinador " + this.adversario.getNome());

        Object vencedor = null;

        while (true) {
            verificarHpPokemons(this.pokemonPlayerEscolhido, this.pokemonAdversarioEscolhido);

            // 0 - Player | 1 - Adversario
            vencedor = verificarVencedor();

            if (vencedor != null) {
                break;
            }

            while (true) {
                Batalha.mostrarInformacoesPokemons(this.pokemonPlayerEscolhido, this.pokemonAdversarioEscolhido);

                try {
                    turnoPlayer();
                } catch (PokemonAbatidoException pokemonAbatidoException) {
                    System.err.println(pokemonAbatidoException.getMessage());
                    break;
                } catch (FugirDaBatalhaException | CapturaPokemonException cannotExecuteMethod) {
                    System.err.println(cannotExecuteMethod.getMessage());
                }

                try {
                    turnoAdversario();
                } catch (PokemonAbatidoException pokemonAbatidoException) {
                    System.err.println(pokemonAbatidoException.getMessage());
                    break;
                }
            }
        }

        if (vencedor.equals(0)) {
            System.out.println("Você venceu!");
        } else if (vencedor.equals(1)) {
            System.err.println("Você perdeu!");
        }
    }

    @Override
    public void turnoPlayer() throws PokemonAbatidoException, FugirDaBatalhaException, CapturaPokemonException {
        int opcaoPlayer = Batalha.opcoesBatalha();

        switch (opcaoPlayer) {
            case 1:
                Movimento movimentoEscolhido = Batalha.escolherMovimentoPokemonPlayer(this.pokemonPlayerEscolhido);
                System.out.printf("%s usou %s%n", this.pokemonPlayerEscolhido.getNome(), movimentoEscolhido.getNome());
                Batalha.atacarPokemon(movimentoEscolhido, this.pokemonAdversarioEscolhido);
                break;
            case 2:
                fugirDaBatalha();
                break;
            case 3:
                irParaMochila();
                break;
        }
    }

    @Override
    public void turnoAdversario() throws PokemonAbatidoException {
        int randIndexMovimento = new Random().nextInt(this.pokemonAdversarioEscolhido.getMovimentos().length);
        Movimento movimentoRandom = this.pokemonAdversarioEscolhido.getMovimentos()[randIndexMovimento];
        System.out.printf("%s usou %s%n", this.pokemonAdversarioEscolhido.getNome(), movimentoRandom.getNome());
        Batalha.atacarPokemon(movimentoRandom, this.pokemonPlayerEscolhido);
    }

    @Override
    public void irParaMochila() throws CapturaPokemonException {
        int opcaoMochila = Batalha.opcoesMochila();

        switch (opcaoMochila) {
            case 1:
                if (this.player.getMochila().getPocoes().isEmpty()) {
                    System.err.println("Sem poções na mochila");
                } else {
                    Pocao pocaoEscolhida = Batalha.escolherPocao(this.player.getMochila());
                    this.player.curarPokemon(pocaoEscolhida, this.pokemonPlayerEscolhido);
                }
                break;
            case 2:
                capturarPokemon();
                break;
        }
    }

    @Override
    public void capturarPokemon() throws CapturaPokemonException {
        throw new CapturaPokemonException("Não pode capturar o pokemon de um treinador!");
    }

    @Override
    public void fugirDaBatalha() throws FugirDaBatalhaException {
        throw new FugirDaBatalhaException("Não pode fugir da batalha!");
    }

    @Override
    public void verificarHpPokemons(Pokemon pokemonPlayer, Pokemon pokemonAdversario) {
        try {
            if (pokemonPlayer.getHpAtual() <= 0) {
                this.pokemonsPlayer = Batalha.removePrimeiroPokemon(this.pokemonsPlayer);
                this.pokemonPlayerEscolhido = this.pokemonsPlayer[0];
            } else if (pokemonAdversario.getHpAtual() <= 0) {
                this.pokemonsAdversario = Batalha.removePrimeiroPokemon(this.pokemonsAdversario);
                this.pokemonAdversarioEscolhido = this.pokemonsAdversario[0];
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    @Override
    public Object verificarVencedor() {
        Object vencedor = null;

        if (this.pokemonsAdversario.length == 0) {
            vencedor = 0;
        } else if (this.pokemonsPlayer.length == 0) {
            vencedor = 1;
        }

        return vencedor;
    }
}
