package filas_dinamicas;

public interface Enfileiravel<T>{
    void enfileirar(T dado);  
    T frente();             
    void atualizarInicio(T dado);   
    void atualizarFim(T dado);         
    T desenfileirar();        
   
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}