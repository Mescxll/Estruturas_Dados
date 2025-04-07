package listas;

public class ListaEstatica implements Listavel {
    private Object[] dados;
    private int quantidade;
    private int ponteiroInicio;
    private int ponteiroFim;
    
    public ListaEstatica(){
        this(10);
    }

    public ListaEstatica(int tamanho){
        dados = new Object[tamanho];
        ponteiroInicio = 0;
        ponteiroFim = -1;
        quantidade = 0;     
    }

    @Override
    public void inserir(Object dado, int posicao) {
        if(!estaCheia()){
            dados[posicao] = dado;
        }else{
            System.err.println("List is Full!");
        }
    }

    @Override
    public void anexar(Object dado) { //Igual a enfileirar da Fila Estatica Circular
        if(!estaCheia()){    
            dados[(ponteiroFim+1)%dados.length] = dado;
            quantidade++;
        }else{
            System.err.println("List is Full!");
        }
    }

    @Override
    public Object selecionar(int posicao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] selecionarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Object dado, int posicao) {
        if(!estaVazia()){
            if(posicao>=0 && posicao<quantidade){
                int posicaoFisica = mapeamento(posicao);
                dados[posicaoFisica] = dado;
            }
        }else{
            System.err.println("List is empty!");
        }
    }

    @Override
    public Object apagar(int posicao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contem(Object dado) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        for(int i = ponteiroInicio;i < quantidade + ponteiroInicio;i++){
            if (i == (quantidade+ponteiroInicio)-1){
                aux += dados[i%dados.length]; //% - Volta para o inicio, se alcançar o fim
            } else {
                aux += dados[i] + ",";
            }
        }
        return aux + "]";
    } 

    public int mapeamento(int posicaoLogica){
        return (posicaoLogica + ponteiroInicio)%dados.length;
    }
}
