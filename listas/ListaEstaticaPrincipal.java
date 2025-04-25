package listas;

public class ListaEstaticaPrincipal {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(8);

        lista.anexar(1);
        lista.anexar(2);
        lista.anexar(3);
        lista.anexar(4);
        lista.anexar(5);
        lista.anexar(6);
        lista.anexar(7);

        System.out.println("Lista: " + lista.imprimir());

        System.out.println("Atualizando o dado -6 na posição 5...");
        lista.atualizar(-6, 5);
        System.out.println("Lista: " + lista.imprimir());

        System.out.println("Inserir o dado 0 na posicão 3...");
        lista.inserir(0, 3);
        System.out.println("Lista: " + lista.imprimir());

        System.out.println("Apagando dado na posição 7...");
        lista.apagar(7);
        System.out.println("Lista: " + lista.imprimir());

        System.out.println("A lista contém o dado -6? " + lista.contem(-6));
        System.out.println("Primeira ocorrência do dado 2: " + lista.primeiraOcorrencia(2));
        System.out.println("Limpando Lista...");
        lista.limpar();
        System.out.println("Lista: " + lista.imprimir());
    }
}
