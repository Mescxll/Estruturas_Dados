package main;

public interface Amontoavel<T>{
    void inserir(T dado);
    Object obterRaiz();
    Object extrair();

    String imprimir();
    boolean estaVazia();
    boolean estaCheia();
}