package unidade2;

import java.util.NoSuchElementException;

public class Questao1 {
    private int tamanho;
    private NoDuplo ponteiroInicio = null;
    private NoDuplo ponteiroFim = null;
    private int quantidade = 0;

    public Questao1(int tamanho) {
        this.tamanho = tamanho;
    }

    public Questao1() {
        this(10);
    }

    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public void anexar(Object dado) {
        if (estaCheia())
            throw new NoSuchElementException("Lista Cheia");

        NoDuplo novoDado = new NoDuplo(dado);
        if (quantidade == 0) {
            ponteiroFim = novoDado;
            ponteiroInicio = novoDado;
        } else {
            ponteiroFim.setProximo(novoDado);
            novoDado.setAnterior(ponteiroFim);
            ponteiroFim = novoDado;
        }
        quantidade++;
    }

    /*public Object apagar(int posicao){
        if(estaVazia())
            throw new NoSuchElementException("Lista Vazia");
        if (posicao<0||posicao>quantidade-1)
            throw new NoSuchElementException("Posição inválida");

        NoDuplo nodo = ponteiroInicio;
        for (int i = 0; i <= posicao; i++) {
            nodo = ponteiroInicio.getProximo();
        }
        
        NoDuplo ponteiroAnterior = nodo.getAnterior();
        NoDuplo ponteiroProximo = nodo.getProximo();

        if (ponteiroAnterior != null) { //nodo não for o primeiro elemento
            ponteiroAnterior.setProximo(ponteiroProximo);
        } else {
            ponteiroInicio = ponteiroInicio.getProximo(); //nodo for o primeiro elemento
        }

        if (ponteiroProximo != null) { //não for o ultimo elemento
            ponteiroProximo.setAnterior(ponteiroAnterior);
            // remocao do fim, joga o ponteiro de fim para o nodo anterior.
        } else {
            ponteiroFim = ponteiroFim.getAnterior(); //for o último elemento
        }

        quantidade--;
        return nodo.getDado();
    }*/


    //Questao 1
    public Object apagar(int posicao) {
        if (estaVazia()) {
            throw new NoSuchElementException("Lista Vazia.");
        }

        if (posicao < 0 || posicao >= quantidade) { 
            throw new IndexOutOfBoundsException(
                    "Posição inválida: " + posicao + ". A lista tem " + quantidade + " elementos.");
        }

        Object dadoApagado;
        NoDuplo noParaRemover;

        if (quantidade == 1) {
            noParaRemover = ponteiroInicio;
            dadoApagado = noParaRemover.getDado();
            ponteiroInicio = null;
            ponteiroFim = null;
        }else if (posicao == 0) {
            noParaRemover = ponteiroInicio;
            dadoApagado = noParaRemover.getDado();
            ponteiroInicio = ponteiroInicio.getProximo();
            if (ponteiroInicio != null) { 
                ponteiroInicio.setAnterior(null);
            }
        }else if (posicao == quantidade - 1) {
            noParaRemover = ponteiroFim;
            dadoApagado = noParaRemover.getDado();
            ponteiroFim = ponteiroFim.getAnterior();
            if (ponteiroFim != null) { 
                ponteiroFim.setProximo(null);
            }
        }else { //do meio
            noParaRemover = ponteiroInicio;
            for (int i = 0; i < posicao; i++) { 
                noParaRemover = noParaRemover.getProximo(); 
            }
            dadoApagado = noParaRemover.getDado();

            noParaRemover.getAnterior().setProximo(noParaRemover.getProximo());
            noParaRemover.getProximo().setAnterior(noParaRemover.getAnterior());
        }

        quantidade--;
        return dadoApagado; 
    }
}
