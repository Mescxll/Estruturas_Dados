package unidade2;

import java.util.NoSuchElementException;

public class Questao3 {
    private int tamanho;
    private NoDuplo ponteiroInicio = null;
    private NoDuplo ponteiroFim = null;
    private int quantidade = 0;

    public Questao3(int tamanho) {
        this.tamanho = tamanho;
    }

    public Questao3() {
        this(10);
    }

    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public void anexar(Object dado){
        if(estaCheia())
            throw new NoSuchElementException("Lista Cheia");
        
        NoDuplo novoDado = new NoDuplo(dado);
        if(quantidade==0){
            ponteiroFim = novoDado;
            ponteiroInicio = novoDado;
        }else{
            ponteiroFim.setProximo(novoDado);
            novoDado.setAnterior(ponteiroFim);
            ponteiroFim = novoDado;
        }
        quantidade++;
    }

    // Questao 1
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
        } else if (posicao == 0) {
            noParaRemover = ponteiroInicio;
            dadoApagado = noParaRemover.getDado();
            ponteiroInicio = ponteiroInicio.getProximo();
            if (ponteiroInicio != null) {
                ponteiroInicio.setAnterior(null);
            }
        } else if (posicao == quantidade - 1) {
            noParaRemover = ponteiroFim;
            dadoApagado = noParaRemover.getDado();
            ponteiroFim = ponteiroFim.getAnterior();
            if (ponteiroFim != null) {
                ponteiroFim.setProximo(null);
            }
        } else { // do meio
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

    // Questao 2
    public String imprimir(){
        String aux = "[";
        NoDuplo pontAux = ponteiroInicio;
        for(int i = 0; i<quantidade; i++){
            if(i==quantidade-1){
                aux += pontAux.getDado();
            }else{
                aux += pontAux.getDado() + ", "; 
            }
            pontAux = pontAux.getProximo();
        }
        return aux + "]";
    }

    //Questao 3
    public int occurrences(Object dado){ //última ocorrência
        NoDuplo pontAux = ponteiroInicio;
        int indice = -1;
        for (int i = 0; i < quantidade; i++) {
            if(pontAux.getDado().equals(dado)){
                indice = i;
            }
            pontAux = pontAux.getProximo();
        }
        return indice;
    }
}
