package questoes_extras;

// Arquivo ListaEstaticaCircular.java

public class Questao {
    private Object[] dados;
    private int quantidade = 0;
    private int ponteiroInicio = 0;
    private int ponteiroFim = -1;
    
    public Questao(int tamanho) {
        dados = new Object[tamanho];
    }

    public Questao() {
        this(10); 
    }

    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }
    
    // 1. Inserir um dado no fim de uma Lista Estática Circular.
    public void inserirNoFim(Object dado){
        if(!estaCheia()){
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            quantidade++;
        }else{
            System.err.println("List is Full!");
        }
    }

    //2. Inserir um dado numa posição lógica específica de uma Lista Estática Circular.
    public void inserir(Object dado, int indice){
        if(!estaCheia()){
            if(indice>=0 && indice<quantidade){
                int posicaoFisica = mapeamento(indice);
                int aux = retroceder(mapeamento(quantidade));
                    while(aux!=retroceder(posicaoFisica)){
                        dados[avancar(aux)] = dados[aux];
                        aux = retroceder(aux);
                    }
                    dados[posicaoFisica]=dado;
                    quantidade++;
                    ponteiroFim = avancar(ponteiroFim);
            }else{
                System.err.println("Invalid Index!");
            }
        }else{
            System.err.println("List is Full!");
        }
    }

    // 14. Apagar um dado do fim de uma Lista Estática Circular.
    public Object apagarNoFim(){
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroFim];
            ponteiroFim = retroceder(ponteiroFim);
            quantidade--;
        }else{
            System.err.println("List is Empty!");
        }
        return aux;
    }

    //17. Ordenar os dados de forma crescente de uma Lista Estática Circular.
    public void ordenarBubble(){
        for(int i = 0 ; i<quantidade; i++){    
            for(int j = i+1 ; j<quantidade; j++){
                if((int) dados[i] > (int)dados[j]){
                    int aux = (int) dados[j];
                    dados[j] = dados[i];
                    dados[i] = aux;
                }
            }
        }
    }

    //18. Ordenar os dados de forma decrescente de uma Lista Estática Circular.
    public void ordenarBubbleDecrescente(){
        for(int i = quantidade-1 ; i>=0; i--){    
            for(int j = i-1 ; j>=0; j--){
                if((int) dados[i]> (int)dados[j]){
                    int aux = (int) dados[j];
                    dados[j] = dados[i];
                    dados[i] = aux;
                }
            }
        }
    }

    //19. Inverter os dados de uma Lista Estática Circular.
    public void inverterDados(){

    }

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

    private int mapeamento(int posicao) {
        return (ponteiroInicio+posicao)%dados.length;
    }

    private int retroceder(int ponteiro) {
        return ((ponteiro-1)+dados.length)%dados.length;
    }

    private int avancar(int ponteiro) {
        return (ponteiro+1)%dados.length;
    }
}
