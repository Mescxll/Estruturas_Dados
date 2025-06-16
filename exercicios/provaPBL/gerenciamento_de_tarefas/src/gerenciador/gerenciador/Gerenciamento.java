
public class Gerenciamento {
    public static void main(String[] args) {
        HeapBinario tarefas = new HeapBinario(30);
    
        Tarefas t1 = new Tarefas("Mudar Interface", 5);
        Tarefas t2 = new Tarefas("Implemmentar fila", 2);
        Tarefas t3 = new Tarefas("Realizar testes de integração", 3);
        Tarefas t4 = new Tarefas("Documentar o código", 1);
        Tarefas t5 = new Tarefas("Planejar próxima sprint", 4);

        tarefas.amontoar(t1);
        tarefas.amontoar(t2);
        tarefas.amontoar(t3);
        tarefas.amontoar(t4);
        tarefas.amontoar(t5);

        System.out.println("Tarefas: " + tarefas.imprimir());
        tarefas.extrair();
        System.out.println("Tarefas: " + tarefas.imprimir());
        System.out.println("Concluídas: " + tarefas.imprimirConcluidas());
    }
    
}
