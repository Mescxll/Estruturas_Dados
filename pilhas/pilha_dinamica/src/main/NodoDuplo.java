package main;

/**
 * Implementação de um Nó duplamente encadeado
 * para trabalhar com etruturas de dados dinâmicas.
 * 
 * @author Maria Eduarda Campos.
 * @version 1.0
 * @since 2025-05-05
 */
public class NodoDuplo<T>{
    private NodoDuplo<T> anterior;
    private NodoDuplo<T> proximo;
    private T dado;

    /**
     * Construtor
     */
    public NodoDuplo(T dado){      
        this.dado = dado;
    }
    
    /**
     * Método para pegar o nodo anterior
     * @return nodo anterior
     */
    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    /**
     * Método para mudar o nodo anterior
     * @param nodo anterior
     */
    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    /**
     * Método para pegar o próximo nodo
     * @return próximo nodo
     */
    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    /**
     * Método para mudar o próximo nodo
     * @param próximo nodo
     */
    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    /**
     * Método para pegar o dado do nodo
     * @return dado
     */
    public T getDado() {
        return dado;
    }

    /**
     * Método para mudar o dado do nodo
     * @param dado
     */
    public void setDado(T dado) {
        this.dado = dado;
    }
}