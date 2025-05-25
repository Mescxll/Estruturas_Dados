/**
 * Implementação de um Nó duplamente encadeado
 * para trabalhar com etruturas de dados dinâmicas.
 * @author Maria Eduarda Campos.
 * @version 1.0
 * @since 2025-05-05
 */

package main;

public class NodoDuplo<T>{
    private NodoDuplo<T> anterior;
    private NodoDuplo<T> proximo;
    private T dado;

    public NodoDuplo(){      
    }

    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    
}