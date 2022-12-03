package br.com.system.batalha;

import br.com.exceptions.CapturaPokemonException;
import br.com.exceptions.FugirDaBatalhaException;
import br.com.exceptions.PokemonAbatidoException;
import br.com.system.mochila.Pocao;
import br.com.system.mochila.Pokebola;
import br.com.system.pokemon.Movimento;
import br.com.system.pokemon.Pokemon;
import br.com.system.treinador.TreinadorComum;

import java.util.Random;

public class BatalhaVsPokemonSelvagem implements Batalha {

    private TreinadorComum player;
    private Pokemon pokemonSelvagem;
    private Pokemon[] pokemonsPlayer;
    private Pokemon pokemonPlayerEscolhido;

    public BatalhaVsPokemonSelvagem(TreinadorComum player, Pokemon pokemonSelvagem) {
        this.player = player;
        this.pokemonSelvagem = pokemonSelvagem;
        this.pokemonsPlayer = Batalha.copyArrayPokemon(this.player.getPokemons());
        this.pokemonPlayerEscolhido = this.pokemonsPlayer[0];
    }

    public TreinadorComum getPlayer() {
        return player;
    }

    public void setPlayer(TreinadorComum player) {
        this.player = player;
    }

    public Pokemon getPokemonSelvagem() {
        return pokemonSelvagem;
    }

    public void setPokemonSelvagem(Pokemon pokemonSelvagem) {
        this.pokemonSelvagem = pokemonSelvagem;
    }

    public Pokemon[] getPokemonsPlayer() {
        return pokemonsPlayer;
    }

    public void setPokemonsPlayer(Pokemon[] pokemonsPlayer) {
        this.pokemonsPlayer = pokemonsPlayer;
    }

    public Pokemon getPokemonPlayerEscolhido() {
        return pokemonPlayerEscolhido;
    }

    public void setPokemonPlayerEscolhido(Pokemon pokemonPlayerEscolhido) {
        this.pokemonPlayerEscolhido = pokemonPlayerEscolhido;
    }

    @Override
    public void iniciarBatalha() {

    }

    @Override
    public void turnoPlayer() throws PokemonAbatidoException, FugirDaBatalhaException, CapturaPokemonException {
        int opcaoPlayer = Batalha.opcoesBatalha();

        switch (opcaoPlayer) {
            case 1:
                Movimento movimentoEscolhido = Batalha.escolherMovimentoPokemonPlayer(this.pokemonPlayerEscolhido);
                System.out.printf("%s usou %s%n", this.pokemonPlayerEscolhido.getNome(), movimentoEscolhido.getNome());
                Batalha.atacarPokemon(movimentoEscolhido, this.pokemonSelvagem);
                break;
            case 2:
                fugirDaBatalha();
                break;
            case 3:
                irParaMochila();
        }
    }

    @Override
    public void turnoAdversario() throws PokemonAbatidoException, FugirDaBatalhaException {

    }

    @Override
    public void irParaMochila() throws CapturaPokemonException {
        int opcaoMochila = Batalha.opcoesMochila();

        switch (opcaoMochila) {
            case 1:
                if (this.player.getMochila().getPocoes().isEmpty()) {
                    System.err.println("Sem poções na mochila!");
                } else {
                    Pocao pocaoEscolhida = Batalha.escolherPocao(this.player.getMochila());
                    this.player.curarPokemon(pocaoEscolhida, this.pokemonPlayerEscolhido);
                }
                break;
            case 2:
                if (this.player.getMochila().getPokebolas().isEmpty()) {
                    System.err.println("Sem pokebolas na mochila!");
                } else {
                    capturarPokemon();
                }
                break;
        }
    }

    @Override
    public void capturarPokemon() throws CapturaPokemonException {
        Pokebola pokebolaEscolhida = Batalha.escolherPokebola(this.player.getMochila());
        this.player.capturarPokemon(pokebolaEscolhida, this.pokemonSelvagem);
        throw new CapturaPokemonException("Pokemon " + this.pokemonSelvagem.getNome() + " capturado!");
    }

    @Override
    public void fugirDaBatalha() throws FugirDaBatalhaException {
        boolean[] booleans = {true, false};

        int randomIndex = new Random().nextInt(booleans.length);

        boolean isFugiu = booleans[randomIndex];

        if (isFugiu) {
            throw new FugirDaBatalhaException("Fugiu com sucesso!");
        }
    }

    @Override
    public void verificarHpPokemons(Pokemon pokemonPlayer, Pokemon pokemonAdversario) {
        if (pokemonPlayer.getHpAtual() <= 0) {
            this.pokemonsPlayer = Batalha.removePrimeiroPokemon(this.pokemonsPlayer);
            try {
                this.pokemonPlayerEscolhido = this.pokemonsPlayer[0];
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
    }

    @Override
    public Object verificarVencedor() {
        Object vencedor = null;

        if (this.pokemonSelvagem.getHpAtual() <= 0) {
            vencedor = this.player;
        } else if (this.pokemonsPlayer.length == 0) {
            vencedor = this.pokemonSelvagem;
        }

        return vencedor;
    }
}
