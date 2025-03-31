package filas_circulares;

public class FilaEstaticaCircularPrincipal { 
    public static void main(String[] args) {
        Enfileiravel filaC = new FilaEstaticaCircular(8);
        filaC.enfileirar(1);
        filaC.enfileirar(2);
        filaC.enfileirar(3);
        filaC.enfileirar(4);
        filaC.enfileirar(5); 
        filaC.enfileirar(6);
        filaC.enfileirar(7);
        filaC.enfileirar(8);

        System.out.println(filaC.imprimir());
        filaC.desenfileirar();
        System.out.println("A frente é: " + filaC.frente());
        filaC.enfileirar(12);
        filaC.atualizarInicio(0);
        filaC.atualizarFim(0);
        System.out.println(filaC.imprimir());
        filaC.desenfileirar();
        System.out.println("A frente é: " + filaC.frente());
        System.out.println(filaC.imprimir());
        
    }  
}
