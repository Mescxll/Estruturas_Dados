package main;

public interface Listavel<T> {
	void anexar(T dado);
	void inserir(int posicao, T dado);
	
	T selecionar(int posicao);
	T[] selecionarTodos();

	void atualizar(int posicao, T novoDado);
	T apagar(int posicao);
    void limpar();
	
	boolean estaCheia();
	boolean estaVazia();
	String imprimir();
}