package pilha_dupla;

public interface Empilhavel { 
	// Operações principais

	void empilhar1(Object dado); 
    void empilhar2(Object dado); 

	Object desempilhar1();
    Object desempilhar2();  

	Object espiar1(); 
    Object espiar2(); 

	void atualizar1(Object dado); 
    void atualizar2(Object dado); 

	// Operações auxiliares

	boolean estaCheia1();
    boolean estaCheia2(); 

	boolean estaVazia1();
    boolean estaVazia2(); 

	String imprimir1(); 
    String imprimir2(); 
}
