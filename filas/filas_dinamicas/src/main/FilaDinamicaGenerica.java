package main;

import java.util.NoSuchElementException;

/**
 * Código referente a implementação de uma fila dinâmica genérica
 * feito na aula de Estrutura de Dados.
 * 
 * @author Maria Eduarda Campos
 * @version 2.0
 * @since 19-05-2025
 */
public class FilaDinamicaGenerica<T> implements Enfileiravel<T>{
    private NodoDuplo<T> ponteiroFim;
    private NodoDuplo<T> ponteiroInicio;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor Vazio
     */
    public FilaDinamicaGenerica(){
        this(10);
    }

    /**
     * Construtor
     */
    public FilaDinamicaGenerica(int tamanho){
        this.tamanho = tamanho;
        quantidade = 0;
        ponteiroFim = null;
        ponteiroInicio = null;
    }

    /**
     * Adiciona um elemento ao final da fila.
     * 
     * @param dado O dado a ser adicionado à fila.
     * @throws NoSuchElementException Se a fila estiver cheia.
     */
    @Override
    public void enfileirar(T dado) {
        if(estaCheia())
            throw new NoSuchElementException("Queue is Full!");
        NodoDuplo<T> novo = new NodoDuplo<>(dado);
        if(estaVazia()){
            ponteiroFim = novo;
            ponteiroInicio = novo;
        }
        novo.setAnterior(ponteiroFim);
        ponteiroFim.setProximo(novo);
        ponteiroFim = novo;
        quantidade++;
    }

    /**
     * Remove e retorna o elemento do início da fila.
     * 
     * @return T O dado removido do início da fila.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    @Override
    public T desenfileirar() {
        if (estaVazia())
            throw new NoSuchElementException("Queue is Empty!");

        T dadoInicio = ponteiroInicio.getDado(); 

        if (quantidade == 1) {
            ponteiroInicio = null;
            ponteiroFim = null;
        } else { 
            ponteiroInicio = ponteiroInicio.getProximo();
            ponteiroInicio.setAnterior(null);
        }

        quantidade--;
        return dadoInicio;
    }

    /**
     * Retorna o elemento do início da fila sem removê-lo.
     * 
     * @return T O dado no início da fila.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    @Override
    public T frente() {
        if(estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        return ponteiroInicio.getDado();
    }

    /**
     * Atualiza o dado do elemento no final da fila.
     * 
     * @param dado O novo dado a ser definido para o elemento no final da fila.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    @Override
    public void atualizarFim(T dado) {
        if(estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        ponteiroFim.setDado(dado);
    }

    /**
     * Verifica se a fila está cheia.
     * 
     * @return boolean true se a fila estiver cheia, false caso contrário.
     */
    @Override
    public boolean estaCheia() {
        return (quantidade == tamanho);
    }

    /**
     * Verifica se a fila está vazia.
     * 
     * @return boolean true se a fila estiver vazia, false caso contrário.
     */
    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    /**
     * Retorna uma representação em String da fila, mostrando seus elementos.
     * 
     * @return String Uma string contendo os elementos da fila, formatados como
     *         [elemento1, elemento2, ..., elementoN].
     */
    @Override
    public String imprimir() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for(int i=0; i<quantidade; i++){
            aux+=ponteiroAux.getDado();
            if(i!=quantidade-1)
                aux+=", ";
            ponteiroAux = ponteiroAux.getProximo();
        }
        return aux + "]";
    }

}
