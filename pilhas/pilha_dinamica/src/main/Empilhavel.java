package main;

public interface Empilhavel<T> { // Stackable
	// Operações principais
	void empilhar(T dado); // push
	T desempilhar(); // pop
	T espiar(); // peek
	void atualizar(T dado); // update

	// Operações auxiliares
	boolean estaCheia(); // isFull -> overflow
	boolean estaVazia(); // isEmpty -> underflow
	String imprimir(); // print
}