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
            if(posicao>=0 && posicao<=quantidade){
                int posicaoFisica = mapeamento(posicao); //desnecessário caso use apenas o x
                int x = ponteiroFim;
                int y = avancar(x);
                for(int i = 0; i < quantidade - posicao; i++){
                    dados[y] = dados[x];
                    y = x;
                    x = retroceder(x);                  
                }
                dados[posicaoFisica] = dado; //dados[x] = dado;
                ponteiroFim = avancar(ponteiroFim);
                quantidade++;
            }else{
                System.err.println("Invalid index!");
            }
        }else{
            System.err.println("List is Full!");
        }
    }

    @Override
    public void anexar(Object dado) { //Igual a enfileirar da Fila Estatica Circular
        if(!estaCheia()){    
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado; //avancar
            quantidade++;
        }else{
            System.err.println("List is Full!");
        }
    }

    @Override
    public Object selecionar(int posicao) {
        Object aux = null;
        if(!estaVazia()){
            if(posicao>=0 && posicao<quantidade){
                int posicaoFisica = mapeamento(posicao);
                aux = dados[posicaoFisica];
            }else{
                System.err.println("Invalid index!");
            }
        }else{
            System.err.println("List is empty!");
        }
        return aux;
    }

    @Override
    public Object[] selecionarTodos() {
        Object[]dadosAux = null;      
        if(!estaVazia()){
            dadosAux = new Object[quantidade];
            for(int i = 0; i < quantidade; i++){
                dadosAux[i] = dados[mapeamento(i)]; 
            }           
        }else{
            System.err.println("List is Empty!");
        }
        return dadosAux;
    }

    @Override
    public void atualizar(Object dado, int posicao) {
        if(!estaVazia()){
            if(posicao>=0 && posicao<quantidade){
                int posicaoFisica = mapeamento(posicao);
                dados[posicaoFisica] = dado;
            }else{
                System.err.println("Invalid index!");
            }
        }else{
            System.err.println("List is empty!");
        }
    }

    @Override
    public Object apagar(int posicao) {
        Object dadoAux = null;
        if(!estaVazia()){
            if(posicao>=0 && posicao < quantidade){
                int posicaoFisica = mapeamento(posicao);
                dadoAux = dados[posicaoFisica];
                int x = posicaoFisica;
                int y = avancar(x);
                for(int i = 0; i < quantidade-posicao-1; i++){
                    dados[x] = dados[y];
                    x = avancar(x);
                    y = avancar(y);
                }
                quantidade--;
                ponteiroFim = retroceder(ponteiroFim);
            }
        }else{
            System.err.println("List is Empty!");
        }
        return dadoAux;
    }

    @Override
    public void limpar() {
        quantidade = 0;
        ponteiroInicio =0;
        ponteiroFim = -1;
    }

    @Override
    public boolean contem(Object dado) {
        int ponteiroAux = ponteiroInicio;
        boolean aux = false;
        if(!estaVazia()){
            for(int i = ponteiroInicio; i < quantidade; i++){
                if(dados[ponteiroAux%dados.length]==dado){
                    return true;
                } 
                ponteiroAux++;
            }
        }else{
            System.err.println("List is Empty!");         
        }  
        return aux; 
    }

    @Override
    public int primeiraOcorrencia(Object dado) {
        int ponteiroAux = ponteiroInicio;
        int aux = -1;
        if(!estaVazia()){
            for(int i = ponteiroInicio; i < quantidade; i++){
                if(dados[ponteiroAux%dados.length]==dado){
                    aux = ponteiroAux%dados.length;
                    return aux;
                } 
                ponteiroAux++;
            }
        }else{
            System.err.println("List is Empty!");         
        }  
        return aux;     
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
        for (int i = 0; i < quantidade; i++) {
            if (i == quantidade-1){
                aux += dados[ponteiroAux]; 
            } else {
                aux += dados[ponteiroAux] + ",";
            }
            ponteiroAux = avancar(ponteiroAux); 
        }
        return aux + "]";
    } 

    //private boolean comparator(equals()){
    //}

    private int mapeamento(int posicaoLogica){
        return (posicaoLogica + ponteiroInicio)%dados.length;
    }

    private int avancar(int posicao){
        return (posicao+1)%dados.length;
    }

    private int retroceder(int ponteiro) {
        return ((ponteiro-1)+dados.length)%dados.length;
    }

}