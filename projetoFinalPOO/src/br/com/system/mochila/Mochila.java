package br.com.system.mochila;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private int capacidade;
    private List<ItemPocao> pocoes;
    private List<ItemPokebola> pokebolas;

    public Mochila(int capacidade) {
        this.capacidade = capacidade;
        this.pocoes = new ArrayList<>();
        this.pokebolas = new ArrayList<>();
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<ItemPocao> getPocoes() {
        return pocoes;
    }

    public void setPocoes(List<ItemPocao> pocoes) {
        this.pocoes = pocoes;
    }

    public List<ItemPokebola> getPokebolas() {
        return pokebolas;
    }

    public void setPokebolas(List<ItemPokebola> pokebolas) {
        this.pokebolas = pokebolas;
    }

    public void adicionarItem(Pokebola pokebola, int qtd) {

        if (isMochilaFicarCheia(qtd)) {
            System.err.println("Fora da capacidade!!!");
        } else if (isItemNaMochila(pokebola)) {

            ItemPokebola itemPokebolaExistente = buscarPokebola(pokebola);
            adicionarItemExistente(itemPokebolaExistente, qtd);

        } else {
            ItemPokebola itemPokebolaNovo = new ItemPokebola(qtd, pokebola);
            pokebolas.add(itemPokebolaNovo);
        }
    }

    public void adicionarItem(Pocao pocao, int qtd) {

        if (isMochilaFicarCheia(qtd)) {
            System.err.println("Fora da capacidade!!!");
        } else if (isItemNaMochila(pocao)) {

            ItemPocao itemPocaoExistente = buscarPocao(pocao);
            adicionarItemExistente(itemPocaoExistente, qtd);

        } else {
            ItemPocao itemPocaoNovo = new ItemPocao(qtd, pocao);
            pocoes.add(itemPocaoNovo);
        }
    }

    public void mostrarPocoes() {

        System.out.println("POÇÕES");

        for (ItemPocao itemPocao : pocoes) {
            System.out.printf("Nome: %s X%d%n", itemPocao.getPocao().getNome(), itemPocao.getQuantidade());
        }

    }

    public void mostrarPokebolas() {

        System.out.println("POKEBOLAS");

        for (ItemPokebola itemPokebola : pokebolas) {
            System.out.printf("Nome: %s X%d%n", itemPokebola.getPokebola().getNome(), itemPokebola.getQuantidade());
        }
    }

    private boolean isMochilaFicarCheia(int qtd) {

        int totalItens = 0;

        for (ItemPokebola itemPokebola : pokebolas) {
            totalItens += itemPokebola.getQuantidade();
        }

        for (ItemPocao itemPocao : pocoes) {
            totalItens += itemPocao.getQuantidade();
        }

        return totalItens + qtd > capacidade;
    }

    public ItemPocao buscarPocao(Pocao pocao) {

        ItemPocao itemPocaoParaEncontrar = null;

        for (ItemPocao itemPocao : pocoes) {

            if (itemPocao.getPocao().equals(pocao)) {
                itemPocaoParaEncontrar = itemPocao;
            }
        }

        return  itemPocaoParaEncontrar;
    }

    public ItemPokebola buscarPokebola(Pokebola pokebola) {

        ItemPokebola itemPokebolaParaEncontrar = null;

        for (ItemPokebola itemPokebola : pokebolas) {
            if (itemPokebola.getPokebola().equals(pokebola)) {
                itemPokebolaParaEncontrar = itemPokebola;
            }
        }

        return itemPokebolaParaEncontrar;
    }

    private boolean isItemNaMochila(Pocao pocao) {

        ItemPocao itemPocaoEncontrado = buscarPocao(pocao);

        return itemPocaoEncontrado != null;
    }

    private boolean isItemNaMochila(Pokebola pokebola) {

        ItemPokebola itemPokebolaEncontrado = buscarPokebola(pokebola);

        return itemPokebolaEncontrado != null;
    }

    private void adicionarItemExistente(ItemPokebola itemPokebola, int qtd) {
        int novaQuantidadeItem = itemPokebola.getQuantidade() + qtd;
        itemPokebola.setQuantidade(novaQuantidadeItem);
    }

    private void adicionarItemExistente(ItemPocao itemPocao, int qtd) {
        int novaQuantidadeItem = itemPocao.getQuantidade() + qtd;
        itemPocao.setQuantidade(novaQuantidadeItem);
    }

    public void removerItem(Pokebola pokebola, int qtd) {

        if (isItemNaMochila(pokebola)) {

            ItemPokebola itemPokebolaExistente = buscarPokebola(pokebola);
            int novaQuantidadeItem = itemPokebolaExistente.getQuantidade() - qtd;

            if (novaQuantidadeItem <= 0) {
                eliminarItem(pokebola);
            } else {
                itemPokebolaExistente.setQuantidade(novaQuantidadeItem);
            }

        } else {
            System.err.println("Não existe esse item na sua mochila!");
        }

    }

    public void removerItem(Pocao pocao, int qtd) {

        if (isItemNaMochila(pocao)) {

            ItemPocao itemPocaoExistente = buscarPocao(pocao);
            int novaQuantidadeItem = itemPocaoExistente.getQuantidade() - qtd;

            if (novaQuantidadeItem <= 0) {
                eliminarItem(pocao);
            } else {
                itemPocaoExistente.setQuantidade(novaQuantidadeItem);
            }

        } else {
            System.err.println("Não existe esse item na sua mochila!");
        }

    }

    public void eliminarItem(Pokebola pokebola) {

        if (isItemNaMochila(pokebola)) {
            ItemPokebola itemPokebolaExistente = buscarPokebola(pokebola);
            pokebolas.remove(itemPokebolaExistente);

        } else {
            System.err.println("Não existe essa pokebola na sua mochila!");
        }
    }

    public void eliminarItem(Pocao pocao) {
        if (isItemNaMochila(pocao)) {
            ItemPocao itemPocaoExistente = buscarPocao(pocao);
            pocoes.remove(itemPocaoExistente);
        } else {
            System.err.println("Não existe essa poção na sua mochila!");
        }
    }
}
