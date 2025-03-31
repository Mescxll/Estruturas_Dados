package pilha_invertida;

public class PilhaEstaticaInvertida implements EmpilhavelInvertida {
    private Object[] dados;
    private int ponteiroTopo;

    public PilhaEstaticaInvertida() {
        this(10);
    }

    public PilhaEstaticaInvertida(int tamanho) {
        dados = new Object[tamanho];
        ponteiroTopo = tamanho; // O último elemento adicionado, agora será o primeiro a se desempilhar
    }

    @Override
    public void empilhar(Object dado) {
        if (!estaCheia()) {
            ponteiroTopo--;
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroTopo];
            ponteiroTopo++;
        } else {
            System.err.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public Object espiar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroTopo];
        } else {
            System.err.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public void atualizar(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    @Override
    public boolean estaCheia() {
        return (ponteiroTopo == 0);
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroTopo == dados.length);
    }

    @Override
    public String imprimir() {
        String aux = "[";
        for (int i = ponteiroTopo; i <= dados.length-1; i++) {
            if (i == dados.length - 1) {
                aux += dados[i];
            } else {
                aux += dados[i] + ",";
            }
        }
        return aux + "]";
    }
}