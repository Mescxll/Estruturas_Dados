package filas_duplas;

public class FilaEstaticaDuplaPrincipal {
    public static void main(String[] args) {
        FilaEstaticaDupla fd = new FilaEstaticaDupla(10);

        fd.enfileirarFim(1);
        fd.enfileirarFim(2);
        fd.enfileirarFim(3);
        fd.enfileirarInicio(4);
        fd.enfileirarInicio(5);
        fd.enfileirarInicio(6);
        fd.enfileirarFim(7);
        fd.enfileirarInicio(8);
        fd.enfileirarInicio(9);

        System.out.println("Fila de Frente para Trás: " + fd.imprimirFrenteTras());
        System.out.println("Fila de Trás para Frente: " + fd.imprimirTrasFrente());
        
        System.out.println("Desenfileirar Fim...");
        fd.desenfileirarFim();

        System.out.println("Fila de Frente para Trás: " + fd.imprimirFrenteTras());
        System.out.println("Fila de Trás para Frente: " + fd.imprimirTrasFrente());

        System.out.println("Desenfileirar Inicio...");
        fd.desenfileirarInicio();

        System.out.println("Fila de Frente para Trás: " + fd.imprimirFrenteTras());
        System.out.println("Fila de Trás para Frente: " + fd.imprimirTrasFrente());
    
        System.out.println("Atualizando Inicio e Fim (-1 e 0)...");
        fd.atualizarInicio(-1);
        fd.atualizarFim(0);

        System.out.println("Fila de Frente para Trás: " + fd.imprimirFrenteTras());
        System.out.println("Fila de Trás para Frente: " + fd.imprimirTrasFrente());
    
        System.out.println("Frente: " + fd.frente());
        System.out.println("Trás: " + fd.tras());
    }
}
