package qt2e3;

public class Questao3{
    private Object[] dados;
    private int quantidade = 0;
    private int ponteiroInicio = 0;
    private int ponteiroFim = -1;

    public Questao3(int tamanho) {
        dados = new Object[tamanho];
    }

    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    } 
    
    public String imprimirAte(int indice){
        String aux = "[";
        int ponteiroAux = ponteiroInicio;
        for(int i = 0; i <= indice; i++){
            if(i==indice){
                aux += dados[ponteiroAux];
            }else{
                aux += dados[ponteiroAux] + ", ";
            }
            ponteiroAux = avancar(ponteiroAux);
        }
        return aux + "]";
    }

    private int avancar(int ponteiro) {
       return (ponteiro+1)%dados.length;
    } 
}