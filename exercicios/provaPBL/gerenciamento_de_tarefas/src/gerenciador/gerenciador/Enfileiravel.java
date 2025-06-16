
public interface Enfileiravel {
    void enfileirar(Tarefas dado);
    Tarefas desenfileirar();
    Tarefas frente();
    void atualizar(Tarefas dado);

    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}
