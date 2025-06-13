package fila_com_pilhas;

public class FilaComPilhasPrincipal {
    public static void main(String[] args) {
        FilaComPilhas fp = new FilaComPilhas(8);
        
        fp.enfileirar(1);
        fp.enfileirar(2);
        fp.enfileirar(3);
        fp.enfileirar(4);
        fp.enfileirar(5);
        fp.enfileirar(6);

        System.out.println("Fila: " + fp.imprimir());
        fp.desenfileirar();
        System.out.println("Desenfileirando...");
        System.out.println("Fila: " + fp.imprimir());

        fp.atualizarInicio(0);
        System.out.println("Atualizando Inicio...");
        System.out.println("Fila: " + fp.imprimir());
        fp.atualizarFim(-1);
        System.out.println("Atualizando Fim...");
        System.out.println("Fila: " + fp.imprimir());
        System.out.println("A frente é: " + fp.frente());
    }
}
