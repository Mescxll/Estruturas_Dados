package filas_duplas;

public class FilaEstaticaDupla implements DuplamenteEnfileravel {
    private Object[] dados;
    private int ponteiroInicio;
    private int ponteiroFim;
    private int quantidade;

    public FilaEstaticaDupla() {
        this(10);
    }

    public FilaEstaticaDupla(int tamanho) {
        ponteiroInicio = 0;
        ponteiroFim = -1;
        quantidade = 0;
        dados = new Object[tamanho];
    }

    @Override
    public void enfileirarInicio(Object dado) {
        if (!estaCheia()) {
            ponteiroInicio = retroceder(ponteiroInicio);
            dados[ponteiroInicio] = dado;
            quantidade++;
            if(estaVazia()){
                ponteiroFim = ponteiroInicio;
            }
        } else {
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public void enfileirarFim(Object dado) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            quantidade++;
            if(estaVazia()){
                ponteiroInicio = ponteiroFim;
            }
        } else {
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public Object desenfileirarInicio() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
            ponteiroInicio = avancar(ponteiroInicio);
            quantidade--;
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object desenfileirarFim() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroFim];
            ponteiroFim = retroceder(ponteiroFim);
            quantidade--;
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object frente() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object tras() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroFim];
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public void atualizarInicio(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is Empty!!!");
        }
    }

    @Override
    public void atualizarFim(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroFim] = dado;
        } else {
            System.err.println("Queue is Empty!!!");
        }
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimirFrenteTras() {
        String aux = "[";
        int ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            if (i == quantidade - 1) {
                aux += dados[ponteiroAux]; 
            } else {
                aux += dados[ponteiroAux] + ",";
            }
            ponteiroAux = avancar(ponteiroAux);
        }
        return aux + "]";
    }

    @Override
    public String imprimirTrasFrente() {
        String aux = "[";
        int ponteiroAux = ponteiroFim;
        for (int i = 0; i < quantidade; i++) {
            if (i == quantidade - 1) {
                aux += dados[ponteiroAux]; 
            } else {
                aux += dados[ponteiroAux] + ",";
            }
            ponteiroAux = retroceder(ponteiroAux);
        }
        return aux + "]";
    }

    private int avancar(int ponteiro){
        return (ponteiro+1)%dados.length;
    }

    private int retroceder(int ponteiro){
        return ((ponteiro-1)+dados.length)%dados.length;
    }
}
