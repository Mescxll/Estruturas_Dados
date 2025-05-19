package pilha_estatica.pilha;

public class PilhaEstatica implements Empilhavel{
    private Object[] dados;
    private int ponteiroTopo;

    public PilhaEstatica() { //Caso não entre paramêtros, inicializa com um tamanho padrão 10
       this(10); //Chama o outro construtor
    }

    public PilhaEstatica(int tamanho) {
        dados = new Object[tamanho];
        ponteiroTopo = -1;
    }

    //Incrementa o ponteiro topo e então adiciona o elemento
    @Override
    public void empilhar(Object dado) {
        if(!estaCheia()){
            ponteiroTopo++;
            dados[ponteiroTopo]=dado;
        }else{
            System.err.println("Stack is full!"); 
            //Criar excessão de OverFlow
        }
    }
    
    @Override
    public Object desempilhar() {
        Object aux = null;
        if(!estaVazia()) {         
            aux = dados[ponteiroTopo];
            //dados[ponteiroTopo] = null; -> se desejar apagar o dado desempilhado
            ponteiroTopo--;
        }else{
            System.err.println("Stack is empty!");   
            //Criar excessão de UnderFlow    
        }
        return aux;
    }

    @Override
    public Object espiar() {
        Object aux = null;
        if(!estaVazia()) {         
            aux = dados[ponteiroTopo];
        }else{
            System.err.println("Stack is empty!");           
        }
        return aux;
    }

    @Override
    public void atualizar(Object dado) {
        if(!estaVazia()){          
            dados[ponteiroTopo]=dado;
        }else{
            System.err.println("Stack is empty!"); 
        }
    }

    @Override
    public boolean estaCheia() {
        return (ponteiroTopo == dados.length - 1);
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroTopo == -1); 
    }

    @Override 
    public String imprimir() {
        String aux = "[";
        for(int i = ponteiroTopo; i >= 0; i--){
            if(i==0)
                aux += dados[i];
            else
                aux += dados[i] + ",";
        } 
        return aux + "]";
    }
}