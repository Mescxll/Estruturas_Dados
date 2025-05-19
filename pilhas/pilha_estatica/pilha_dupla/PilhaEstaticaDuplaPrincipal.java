package pilha_estatica.pilha_dupla;

public class PilhaEstaticaDuplaPrincipal {
    public static void main(String[] args) {
        EmpilhavelDupla pilha = new PilhaEstaticaDupla(5);

        pilha.empilhar1("Olá");
        pilha.empilhar1("Mundo");
        System.out.println("Topo 1: " + pilha.espiar1()); // Mundo

        pilha.empilhar2("Hey");
        pilha.empilhar2("Você");
        pilha.empilhar2("Tudo bem?");
        System.out.println("Topo 2: " + pilha.espiar2()); // Tudo bem?

        System.out.println("------------------------");

        System.out.println("Pilha 1: " + pilha.imprimir1());
        System.out.println("Pilha 2: " + pilha.imprimir2());

        System.out.println("------------------------");

        pilha.desempilhar1(); // Retira Mundo
        pilha.desempilhar2(); // Retira Tudo bem?

        pilha.empilhar1("Universo"); // Adiciona Universo
        pilha.empilhar2("E aí?"); // Adiciona E aí?

        System.out.println("Pilha 1: " + pilha.imprimir1());
        System.out.println("Pilha 2: " + pilha.imprimir2());

        System.out.println("------------------------");

        Object conteudo1 = pilha.desempilhar1(); // Retira Universo e põe em conteudo1
        Object conteudo2 = pilha.desempilhar2(); // Retira E aí? e põe em conteudo2

        System.out.println("Topo 1: " + pilha.espiar1()); // Olá
        System.out.println("Topo 2: " + pilha.espiar2());// Você

        System.out.println("------------------------");

        pilha.empilhar1("Pessoas"); // Adiciona Pessoas
        pilha.empilhar2("Como vai?"); // Adiciona Como vai?

        System.out.println("Pilha 1: " + pilha.imprimir1());
        System.out.println("Pilha 2: " + pilha.imprimir2());

        System.out.println("------------------------");

        pilha.desempilhar1(); // Retira Pessoas
        pilha.desempilhar2(); // Retira Como vai?

        pilha.empilhar1(conteudo1); // Adiciona o conteudo1
        pilha.empilhar2(conteudo2); // Adiciona o conteudo2

        System.out.println("Pilha 1: " + pilha.imprimir1());
        System.out.println("Pilha 2: " + pilha.imprimir2());
    }
}