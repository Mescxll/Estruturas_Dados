package filas_circulares;

public class FilaEstaticaCircular implements Enfileiravel{
    private Object[] dados;    
    private int ponteiroInicio; 
    private int ponteiroFim;  
    private int quantidade;  

    public FilaEstaticaCircular() {
        this(10);
    }

    public FilaEstaticaCircular(int tamanho) {
        ponteiroInicio = 0;
        ponteiroFim = -1;
        quantidade = 0;
        dados = new Object[tamanho];
    }

    @Override
    public void enfileirar(Object dado) {
        if(!estaCheia()){
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            quantidade++;
            if(estaVazia()){
                ponteiroInicio = ponteiroFim;
            }
        }else{
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public Object desenfileirar() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
            ponteiroInicio = avancar(ponteiroInicio);
            quantidade--;
        }else{
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object frente() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
        }else{
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public void atualizarInicio(Object dado) {
        if(!estaVazia()){
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is Empty!!!");
        }
    }

    @Override
    public void atualizarFim(Object dado) {
        if(!estaVazia()){
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
    public String imprimir() {
        String aux = "[";
        int ponteiroAux = ponteiroInicio;
        for(int i = 0; i < quantidade; i++){
            if (i == quantidade-1){
                aux += dados[ponteiroAux]; //% - Volta para o inicio, se alcançar o fim
            } else {
                aux += dados[ponteiroAux] + ",";
            }
            ponteiroAux = avancar(ponteiroAux);
        }
        return aux + "]";
    } 

    private int avancar(int ponteiro){
        return (ponteiro+1)%dados.length;
    }
}
