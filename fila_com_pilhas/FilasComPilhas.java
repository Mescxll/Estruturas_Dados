package fila_com_pilhas;

import filas.Enfileiravel;
import pilha.Empilhavel;
import pilha.PilhaEstatica;

public class FilasComPilhas implements Enfileiravel{
    private Empilhavel p1;
    private Empilhavel p2;

    public FilasComPilhas(int tamanho){
        p1 = new PilhaEstatica(tamanho);
        p2 = new PilhaEstatica(tamanho);
    }

    public FilasComPilhas(){
        this(10);                      
    }

    @Override
    public void enfileirar(Object dado) {        
        if(!estaCheia())
            p1.empilhar(dado);
        else
            System.err.println("Queue is Full");
    }

    @Override
    public Object desenfileirar() {
        Object dadoInicio = null;
        while(!p1.estaVazia())
            p2.empilhar(p1.desempilhar());
        dadoInicio = p2.desempilhar();
        while(!p2.estaVazia())
            p1.empilhar(p2.desempilhar());
        return dadoInicio;
    }

    @Override
    public void atualizarFim(Object dado) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void atualizarInicio(Object dado) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean estaCheia() {
        return p1.estaCheia();
    }

    @Override
    public boolean estaVazia() {
        return p1.estaVazia();
    }

    @Override
    public Object frente() {
        Object dadoInicio = null;
        while(!p1.estaVazia())
            p2.empilhar(p1.desempilhar());
        dadoInicio = p2.espiar();
        while(!p2.estaVazia())
            p1.empilhar(p2.desempilhar());
        return dadoInicio;
    }

    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
