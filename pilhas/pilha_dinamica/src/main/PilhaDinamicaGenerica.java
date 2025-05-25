/**
 * Código referente a implementação de uma pilha dinâmica genérica 
 * feito na aula de Estrutura de Dados.
 * @author Maria Eduarda Campos
 * @version 1.0
 * @since 2025-05-05
 */

package main;

import java.util.NoSuchElementException;

public class PilhaDinamicaGenerica<T> implements Empilhavel<T> {
    private NodoDuplo<T> ponteiroTopo;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor que inicializa um objeto com 
     * um paramêtro.
     * @param tamanho, refere-se ao tamanho 
     * máx que a ED pode ter.
     */
    public PilhaDinamicaGenerica(int tamanho){
        this.tamanho = tamanho;
        quantidade = 0;
    } 

    /**
     * Construtor Vazio
     */
    public PilhaDinamicaGenerica(){
        this(10);
    }

    /**
     * Adiciona um elemento no topo da pilha (empilha).
     * @param dado que será empilhado. 
     * @throws NoSuchElementException se a pilha
     * estiver cheia.
     */
    @Override
    public void empilhar(T dado) {
        if(estaCheia())
            throw new NoSuchElementException("Stack is Full!");
        NodoDuplo<T> novo = new NodoDuplo<>();
        if (ponteiroTopo == null) {
            ponteiroTopo = novo;
        }
        novo.setDado(dado);
        novo.setAnterior(ponteiroTopo);
        ponteiroTopo.setProximo(novo);
        ponteiroTopo = novo;
        quantidade++;
    }

    /**
     * Retira o elemento no topo da pilha (desempilha).
     * @return o elemento desempilhado.
     * @throws NoSuchElementException se a pilha
     * estiver vazia.
     */
    @Override
    public T desempilhar() {
        if(estaVazia())
            throw new NoSuchElementException("Stack is Empty!");
        T aux = ponteiroTopo.getDado();
        ponteiroTopo = ponteiroTopo.getAnterior();
        ponteiroTopo.setProximo(null);
        quantidade--;
        return aux;
    }

    /**
     * Mostra o elemento no topo da pilha.
     * @return o conteúdo do topo da pilha.
     * @throws NoSuchElementException se a pilha
     * estiver vazia.
     */
    @Override
    public T espiar(){
        if(estaVazia())
            throw new NoSuchElementException("Stack is Empty!");
        return ponteiroTopo.getDado();
    }

    /**
     * Atualiza o elemento do topo da pilha.
     * @param dado que vai ser atualizado.
     * @throws NoSuchElementException se a pilha
     * estiver vazia.
     */
    @Override
    public void atualizar(T dado) {
        if(estaVazia())
            throw new NoSuchElementException("Stack is Empty!");
        ponteiroTopo.setDado(dado);
        
    }

    /**
     * Verifica se a pilha está cheia
     * @return true, se estiver, false caso 
     * contrário.
     */
    @Override
    public boolean estaCheia(){
        return (quantidade==tamanho);
    }

    /**
     * Verifica se a pilha está vazia
     * @return true, se estiver, false caso 
     * contrário.
     */
    @Override
    public boolean estaVazia(){
        return (quantidade==0);
    }
    
    /**
     * Gera informação textual dos elementos da pilha
     * @return String referente aos elementos até
     * então adicionados na estrutura.
     */
    @Override 
    public String imprimir() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroTopo;
        for(int i = 0; i<quantidade; i++){
            aux += ponteiroAux.getDado();
            if(i!=quantidade-1){
                aux += ", ";
            }
            ponteiroAux = ponteiroAux.getAnterior();
        }
        return aux + "]";
    }
}