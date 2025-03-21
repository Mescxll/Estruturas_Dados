package pilha_invertida;

public interface Empilhavel {
    // Operações principais

    void empilhar(Object dado);

    Object desempilhar();

    Object espiar();

    void atualizar(Object dado);

    // Operações auxiliares

    boolean estaCheia();

    boolean estaVazia();

    String imprimir();
}
