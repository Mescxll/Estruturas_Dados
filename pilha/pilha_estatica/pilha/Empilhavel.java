package pilha;

public interface Empilhavel { // Stackable
	// Operações principais

	void empilhar(Object dado); // push

	Object desempilhar(); // pop

	Object espiar(); // peek

	void atualizar(Object dado); // update

	// Operações auxiliares

	boolean estaCheia(); // isFull -> overflow

	boolean estaVazia(); // isEmpty -> underflow

	String imprimir(); // print
}