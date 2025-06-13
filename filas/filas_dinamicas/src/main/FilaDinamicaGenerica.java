package main;

import java.util.NoSuchElementException;

public class FilaDinamicaGenerica<T> implements Enfileiravel<T>{
    private NodoDuplo<T> ponteiroFim;
    private NodoDuplo<T> ponteiroInicio;
    private int quantidade;
    private int tamanho;

    public FilaDinamicaGenerica(){
        this(10);
    }

    public FilaDinamicaGenerica(int tamanho){
        this.tamanho = tamanho;
        quantidade = 0;
        ponteiroFim = null;
        ponteiroInicio = null;
    }

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

    @Override
    public T desenfileirar() {
        if(estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        T dadoInicio = ponteiroInicio.getDado();
        ponteiroInicio = ponteiroInicio.getProximo();
        if (!estaVazia()) 
			ponteiroInicio.setAnterior(null);
		else 
			ponteiroFim = null;
		
        quantidade--;
        return dadoInicio;
    }

    @Override
    public T frente() {
        if(estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        return ponteiroInicio.getDado();
    }

    @Override
    public void atualizarInicio(T dado) {
        if(estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        ponteiroInicio.setDado(dado);
    }

    @Override
    public void atualizarFim(T dado) {
        if(estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        ponteiroFim.setDado(dado);
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == tamanho);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

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
