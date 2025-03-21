package pilha;

public class PilhaEstaticaPrincipal {
    public static void main(String[] args) {
        // PilhaEstatica p1 = new PilhaEstatica(30); -> criando por meio da classe
        // concreta
        Empilhavel pilha = new PilhaEstatica(30); // -> por meio da interface
        pilha.empilhar("Instituto");
        pilha.empilhar("Federal");

        System.out.println("Espiar:" + pilha.espiar());

        pilha.empilhar("de");
        pilha.empilhar("Educação");
        pilha.empilhar("Ciência");
        pilha.empilhar("e");

        System.out.println("Espiar:" + pilha.espiar());

        Object conteudo = pilha.desempilhar();
        pilha.desempilhar();

        pilha.empilhar("Tecnologia");
        pilha.empilhar("da");
        pilha.empilhar("Bahia");
        pilha.atualizar("Pará");

        pilha.empilhar(pilha.desempilhar());

        pilha.empilhar(conteudo);
        System.out.println("Pilha=" + pilha.imprimir());
    }
}
