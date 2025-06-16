package questoes_extras;

public class Principal {
    public static void main(String[] args) {
        Questao qt = new Questao(10);
        qt.inserirNoFim(5);
        qt.inserirNoFim(3);
        qt.inserirNoFim(1);
        qt.inserirNoFim(4);
        qt.inserirNoFim(2);
        System.out.println(qt.imprimir());

        //qt.ordenarBubble();
        //System.out.println(qt.imprimir());

        //qt.ordenarBubbleDecrescente();
        //System.out.println(qt.imprimir());

        qt.inserir(6, 2);
        System.out.println(qt.imprimir());
    }
}
