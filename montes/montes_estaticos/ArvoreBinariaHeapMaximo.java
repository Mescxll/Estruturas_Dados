import java.util.NoSuchElementException;

public class ArvoreBinariaHeapMaximo implements Amontoavel{
    private Object[] dados;
    private int ponteiroFim;

    public ArvoreBinariaHeapMaximo(int tamanho){
        this.dados = new Object[tamanho];
        this.ponteiroFim = -1;
    }

    private int indicePai(int filho){
        return (int) (filho-1)/2; 
    }

    private void trocar(int i, int j){
        Object temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp; 
    }

    private int indiceFilhoEsquerda(int pai) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'indiceFilhoEsquerda'");
    }

    private int indiceFilhoDireito(int pai) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void inserir(Object dado) {
        if(estaCheia())
            //throw new OverFlowException("Heap Cheia");
        ponteiroFim++;
        dados[ponteiroFim] = dado;
        ajustarAcima(ponteiroFim);
    }

    @Override
    public Object obterRaiz() {
        if(estaVazia()){
            throw  new NoSuchElementException("Heap Vazio");
        }
            return dados[0];
    }

    @Override
    public Object extrair() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void ajustarAcima(int filho) {
        int indiceFilho = filho;
        while(indiceFilho!=0){
           int indicePai = indicePai(filho);
            if((int) dados[indiceFilho] > (int) dados[indicePai]){
                trocar(indiceFilho, indicePai);
            } 
            indiceFilho = indicePai;
        }
    }

    private void ajustarAcimaRecursivo(int filho) {
        if(filho!=0){
            int indicePai = indicePai(filho);
            if((int) dados[filho] > (int) dados[indicePai]){
                trocar(filho, indicePai);
            }
            ajustarAcimaRecursivo(indicePai);
        }
    }
    
    private void ajustarAbaixoRec(int pai) {
        int esq = indiceFilhoEsquerda(pai);
        int dir = indiceFilhoDireito(pai);

        int indiceMaior = pai;
        if((int) dados[esq] > (int) dados[indiceMaior]){
            indiceMaior = esq;
        }
        if((int) dados[dir] > (int) dados[indiceMaior]){
            indiceMaior = dir;
        }

        if(indiceMaior!=pai){
            trocar(indiceMaior, pai);
            ajustarAbaixoRec(pai);
        }
    }
                
    @Override
    public boolean estaVazia() {
        return ponteiroFim==-1;
    }

    @Override
    public boolean estaCheia() {
        return ponteiroFim == dados.length-1;
    }

    @Override
    public String imprimir() {
        String aux = "[";
        for (int i = 0; i <= ponteiroFim; i++) {
            aux += dados[i];
            if(i!=ponteiroFim)
                aux+=", ";
        }
        return aux + "]";
    }
}
