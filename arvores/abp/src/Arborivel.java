package abp.src;

public interface Arborivel<T> {
    void inserir(T dado);
    void apagar(T dado);
    boolean existe(T dado);
    NodoTriplo<T> buscar(T dado);
    void limpar();
    NodoTriplo<T> getRaiz();
}