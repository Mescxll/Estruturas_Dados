
public interface Amontoavel {
    Tarefas extrair();
    void amontoar(Tarefas tarefa);
    Tarefas espiar();

    String imprimir();
    boolean estaCheia();
    boolean estaVazia();
}
