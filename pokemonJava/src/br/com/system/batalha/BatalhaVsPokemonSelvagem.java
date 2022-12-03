package br.com.system.batalha;

import br.com.exceptions.CapturaPokemonException;
import br.com.exceptions.FugirDaBatalhaException;
import br.com.exceptions.PokemonAbatidoException;
import br.com.system.pokemon.Pokemon;
import br.com.system.treinador.TreinadorComum;

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

    }

    @Override
    public void turnoAdversario() throws PokemonAbatidoException, FugirDaBatalhaException {

    }

    @Override
    public void irParaMochila() throws CapturaPokemonException {

    }

    @Override
    public void capturarPokemon() throws CapturaPokemonException {

    }

    @Override
    public void fugirDaBatalha() throws FugirDaBatalhaException {

    }

    @Override
    public void verificarHpPokemons(Pokemon pokemonPlayer, Pokemon pokemonAdversario) {

    }

    @Override
    public Object verificarVencedor() {
        return null;
    }
}
