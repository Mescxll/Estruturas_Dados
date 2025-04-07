package pilha_com_filas;

import filas_circulares.Enfileiravel;
import pilha.Empilhavel;
import filas_circulares.FilaEstaticaCircular;

public class PilhaComFilha implements Empilhavel {
    private Enfileiravel f1;
    private Enfileiravel f2;

    public PilhaComFilha(int tamanho){
        f1 = new FilaEstaticaCircular(tamanho);
        f2 = new FilaEstaticaCircular(tamanho);
    }

    public PilhaComFilha(){
        this(10);                      
    }

    @Override
    public void atualizar(Object elemento) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object desempilhar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void empilhar(Object elemento) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object espiar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean estaCheia() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean estaVazia() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        return null;
    }
}
