package br.com.system.batalha;

import br.com.exceptions.CapturaPokemonException;
import br.com.exceptions.FugirDaBatalhaException;
import br.com.exceptions.PokemonAbatidoException;
import br.com.system.pokemon.Pokemon;
import br.com.system.treinador.LiderDeGinasio;
import br.com.system.treinador.TreinadorComum;

public class BatalhaVsLider implements Batalha {

    private TreinadorComum player;
    private LiderDeGinasio adversario;
    private Pokemon[] pokemonsPlayer;
    private Pokemon[] pokemonsAdversario;
    private Pokemon pokemonPlayerEscolhido;
    private Pokemon pokemonAdversarioEscolhido;

    public BatalhaVsLider(TreinadorComum player, LiderDeGinasio adversario) {
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

    public LiderDeGinasio getAdversario() {
        return adversario;
    }

    public void setAdversario(LiderDeGinasio adversario) {
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
        Object vencedor = null;

        if (this.pokemonsAdversario.length == 0) {
            vencedor = this.player;
        } else if (this.pokemonsPlayer.length == 0) {
            vencedor = this.adversario;
        }

        return vencedor;
    }
}
