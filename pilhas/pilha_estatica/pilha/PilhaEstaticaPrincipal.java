package pilha_estatica.pilha;

public class PilhaEstaticaPrincipal {
    public static void main(String[] args) {
        // PilhaEstatica p1 = new PilhaEstatica(30); -> criando por meio da classe
        // concreta
        // Por meio da interface:
        Empilhavel pilha = new PilhaEstatica(30);
        pilha.empilhar("Instituto");
        pilha.empilhar("Federal");

        System.out.println("Topo: " + pilha.espiar());

        pilha.empilhar("de");
        pilha.empilhar("Educação");
        pilha.empilhar("Ciência");
        pilha.empilhar("e");

        System.out.println("Topo: " + pilha.espiar());

        Object conteudo = pilha.desempilhar(); // Retira "e" e o adiciona em 'conteudo'
        pilha.desempilhar(); // Retira "Ciência"

        pilha.empilhar("Tecnologia");
        pilha.empilhar("da");
        pilha.empilhar("Bahia");
        pilha.atualizar("Pará");

        pilha.empilhar(pilha.desempilhar()); // Desempilha e empilha novamente "Pará"

        pilha.empilhar(conteudo); // Empilha "e" guardado em 'conteudo'
        System.out.println("Pilha: " + pilha.imprimir());
    }
}