package filas;

public class FilaEstaticaPrincipal {
    public static void main(String[] args) {
        FilaEstatica fila = new FilaEstatica(10);
        
        fila.enfileirar("Dado 1");
        fila.enfileirar("Dado 2");
        fila.enfileirar("Dado 3");
        fila.enfileirar("Dado 4");
        fila.enfileirar("Dado 5");
        fila.enfileirar("Dado 6");
        fila.enfileirar("Dado 7");
        fila.enfileirar("Dado 8");

        System.out.println("Fila: " + fila.imprimir());
        
        fila.desenfileirar();
        System.out.println("Desenfileirando...");
        System.out.println("Fila: " + fila.imprimir());
        
        fila.enfileirar("Dado 9");
        System.out.println("Enfileirando...");
        System.out.println("Fila: " + fila.imprimir());
        
        fila.atualizarInicio("Dado 0");
        System.out.println("Atualizando Inicio...");
        System.out.println("Fila: " + fila.imprimir());
        
        fila.atualizarFim("Dado -1");
        System.out.println("Atualizando Fim...");
        System.out.println("Fila: " + fila.imprimir());
        
        System.out.println("A frente é: " + fila.frente());
    }
}
