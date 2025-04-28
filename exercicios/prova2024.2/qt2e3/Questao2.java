package qt2e3;

public class Questao2 {
    private Object[] dados;
    private int quantidade = 0;
    private int ponteiroInicio = 0;
    //private int ponteiroFim = -1;

    public Questao2(int tamanho) {
        dados = new Object[tamanho];
    }

    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    } 
    
    public Object apagar(int posicao){
        int posicaoFisica = mapeamento(posicao);
        Object dadoAux = dados[posicaoFisica];
        if(!estaVazia()){
            if (posicao < 0 || posicao >= quantidade) {
                System.err.println("Invalid Index!");
            }else{
                while(posicao!=0){
                    posicaoFisica = mapeamento(posicao);   
                    dados[posicaoFisica] = dados[retroceder(posicaoFisica)];
                    posicao = retroceder(posicao);
                }
                ponteiroInicio = avancar(ponteiroInicio);
                quantidade --;
            }
        }else{
            System.err.println("List is Empty!");
        }
        return dadoAux;
    }

    private int avancar(int ponteiro) {
        return (ponteiro+1)%dados.length;
    }

    private int retroceder(int posicao) {
        return ((posicao-1)+dados.length)%dados.length;
    }

    private int mapeamento(int posicao) {
        return (ponteiroInicio+posicao)%dados.length;
    } 
}
