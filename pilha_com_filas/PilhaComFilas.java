package pilha_com_filas;

import filas_circulares.Enfileiravel;
import pilha.Empilhavel;
import filas_circulares.FilaEstaticaCircular;

public class PilhaComFilas implements Empilhavel {
    private Enfileiravel f1;
    private Enfileiravel f2;

    public PilhaComFilas(int tamanho){
        f1 = new FilaEstaticaCircular(tamanho);
        f2 = new FilaEstaticaCircular(tamanho);
    }

    public PilhaComFilas(){
        this(10);                      
    }

    @Override
    public void empilhar(Object elemento) {
        if(!estaCheia()){
            f1.enfileirar(elemento);
        }else{
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar() {
        Object dadoAux = null;
        if(!estaVazia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            }
            dadoAux = f2.desenfileirar();
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            }
        }else{
            System.err.println("Stack is empty!");
        }
        return dadoAux;
    }

    @Override
    public void atualizar(Object elemento) {
        if (!estaVazia()) {
            f1.atualizarFim(elemento);
        }else{
			System.err.println("Stack is full!");
		}	
    }

    @Override
    public Object espiar() {
        Object dadoAux = null;      
        if(!estaVazia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            }
            dadoAux = f2.frente();
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            }
        }else{
            System.err.println("Stack is empty!");
        }
        return dadoAux;
    }

    @Override
    public boolean estaCheia() {
        return f1.estaCheia();
    }

    @Override
    public boolean estaVazia() {
        return f1.estaVazia();
    }

    @Override
    public String imprimir() {
        return f1.imprimir();
    }
}
