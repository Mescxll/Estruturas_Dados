package main;

import java.util.NoSuchElementException;

/**
 * Implementação da Estrutura Árvore Binária Máxima
 * 
 * @author Maria Eduarda Campos
 * @since 09-06-2025
 */
public class ArvoreBinariaHeapMaximo<T> implements Amontoavel<T> {
    private T[] dados;
    private int ponteiroFim;

    /**
     * Construtor
     * 
     * @param tamanho capacidade do árvore
     */
    public ArvoreBinariaHeapMaximo(int tamanho) {
        dados = (T[]) new Object[tamanho];
        ponteiroFim = -1;
    }

    /**
     * Construtor Vazio
     */
    public ArvoreBinariaHeapMaximo() {
        this(10);
    }

    /**
     * Método para calcular o indice do pai de um nó
     * 
     * @param filho nó a ser analisado
     * @return indice do pai
     */
    private int indicePai(int filho) {
        return (filho - 1) / 2;
    }

    /**
     * Método para calcular o indice do filho direito de um nó
     * 
     * @param pai nó a ser analisado
     * @return indice do filho direito
     */
    private int indiceFilhoDireito(int pai) {
        return (pai * 2) + 1;
    }

    /**
     * Método para calcular o indice do filho esquerdo de um nó
     * 
     * @param pai nó a ser analisado
     * @return indice do filho esquerdo
     */
    private int indiceFilhoEsquerdo(int pai) {
        return (pai * 2) + 2;
    }

    /**
     * Método recursivo para ordernar a árvores de baixo para cima
     * 
     * @param indice posição de ajuste
     */
    private void ajustarAcimaRec(int indice) {
        if (indice != 0) {
            int indicePai = indicePai(indice);
            if ((int) dados[indice] > (int) dados[indicePai])
                trocar(indice, indice);
            ajustarAcimaRec(indicePai);
        }
    }

    /**
     * Método não recursivo para ordernar a árvores de baixo para cima
     * @param indice posição de ajuste
     */
    private void ajustarAcima(int indice) {
        int indiceFilho = indice;
        int indicePai;

        while (indiceFilho != 0) {
            indicePai = indicePai(indiceFilho);
            if ((int) dados[indiceFilho] > (int) dados[indicePai]) {
                trocar(indicePai, indiceFilho);
            }
            indiceFilho = indicePai;
        }
    }

    /**
     * Método não recursivo para ordernar a árvores de baixo para baixo
     * 
     * @param pai raiz da árvore
     */
    private void ajustarAbaixoRec(int pai) {
        int esq = indiceFilhoDireito(pai);
        int dir = indiceFilhoDireito(pai);
        int indiceMaior = pai;
        if ((int) dados[esq] > (int) dados[indiceMaior]) {
            indiceMaior = esq;
        }
        if ((int) dados[dir] > (int) dados[indiceMaior]) {
            indiceMaior = dir;
        }

        if (indiceMaior != pai) {
            trocar(indiceMaior, pai);
            ajustarAbaixoRec(indiceMaior);
        }
    }

    /**
     * Método para inserir dado na árvore
     * @throws Exception se a árvore estiver cheia
     */
    @Override
    public void inserir(T dado) {
        if (estaCheia())
            throw new Exception("Heap is full!");
        ponteiroFim++;
        dados[ponteiroFim] = dado;
        ajustarAcima(ponteiroFim);
    }

    /**
     * Método para obter a raiz da árvore
     * 
     * @return raiz
     * @throws NoSuchElementException se árvore estiver vazia
     */
    @Override
    public T obterRaiz() {
        if (estaVazia()) {
            throw new NoSuchElementException("Heap is empty!");
        }
        return dados[0];
    }

    /**
     * Método para extrair dado da árvore
     * @return dado
     * @throws Exception se a árvore estiver cheia
     */
    @Override
    public T extrair() {
        T dadoRaiz = null;
        if (estaVazia()) {
            throw new Exception("Heap is full!");
        }

        dadoRaiz = dados[0];
        dados[0] = dados[ponteiroFim];
        ponteiroFim--;
        ajustarAcima(ponteiroFim);
        return dadoRaiz;
    }

    /**
     * Método para imprimir conteúdo da árvore
     * @return String com o conteúdo
     */
    @Override
    public String imprimir() {
        String aux = "[";

        for (int i = 0; i <= ponteiroFim; i++) {
            aux += dados[i];
            if (i != ponteiroFim) {
                aux += ", ";
            }
        }
        return aux;
    }

    /**
     * Método que verifica se a árvore está vazia
     * 
     * @return true se estiver vazia e false caso contrário
     */
    @Override
    public boolean estaVazia() {
        return ponteiroFim == -1;
    }

    /**
     * Método que verifica se a árvore está cheia
     * 
     * @return true se estiver cheia e false caso contrário
     */
    @Override
    public boolean estaCheia() {
        return ponteiroFim == dados.length - 1;
    }

    /**
     * Método que troca dois elementos na árvore
     * @param i primeiro elemento
     * @param j segundo elemento
     */
    private void trocar(int i, int j) {
        T temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp;
    }

}
