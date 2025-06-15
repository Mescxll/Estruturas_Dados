package main;

public interface Enfileiravel<T>{
    void enfileirar(T dado);  
    T frente();               
    void atualizarFim(T dado);         
    T desenfileirar();        
   
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}