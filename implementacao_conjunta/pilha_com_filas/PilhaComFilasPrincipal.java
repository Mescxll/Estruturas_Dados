package pilha_com_filas;

public class PilhaComFilasPrincipal {
    public static void main(String[] args) {
        PilhaComFilas pilha = new PilhaComFilas(12);
        
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        pilha.empilhar(4);
        pilha.empilhar(5);
        pilha.empilhar(6);

        System.out.println("Pilha: " + pilha.imprimir());
        System.out.println("Topo: " + pilha.espiar());

        System.out.println("Desempilhando...");
        pilha.desempilhar(); 

        System.out.println("Pilha: " + pilha.imprimir());

        System.out.println("Empilhando...");
        pilha.empilhar(7);
        pilha.empilhar(8);
        pilha.empilhar(9);
        pilha.atualizar(0);

        System.out.println("Pilha: " + pilha.imprimir());
    }
}
