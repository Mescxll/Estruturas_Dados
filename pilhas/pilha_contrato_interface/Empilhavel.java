package pilha_contrato_interface;

//Stack (pilha) - Contrato (código genérico)
public interface Empilhavel {
	// Operações principais
	void empilhar(Object dado); // push
	Object desempilhar(); // pop
	Object retornarTopo(); // top //espiar(peek)
	void atualizar(Object dados); // update

	// Operações auxiliares
	Boolean estaCheia(); // isFull -> overflow
	Boolean estaVazia(); // isEmpty -> underflow
	String imprimir(); // print
}
