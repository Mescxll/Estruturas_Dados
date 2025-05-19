package pilha_dinamica.src;

public class PilhaDinamicaGenericaMainCLI {
    
    public static void main(String[] args) {
        Empilhavel pilha = new PilhaDinamicaGenerica(50);

        pilha.empilhar(5);
        pilha.empilhar(3);
        pilha.empilhar(6);
        pilha.empilhar(8);
        System.out.println(pilha.imprimir());
    }
}
