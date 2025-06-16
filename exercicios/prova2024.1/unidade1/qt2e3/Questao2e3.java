package qt2e3;
// Arquivo ListaEstaticaCircular.java

public class Questao2e3 {
    private Object[] dados;
    private int quantidade = 0;
    private int ponteiroInicio = 0;
    private int ponteiroFim = -1;

    public Questao2e3(int tamanho) {
        dados = new Object[tamanho];
    }

    public Questao2e3() {
        this(10); 
    }

    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    // Implementação dos métodos para as questões 2 e 3 pode ser colocada aqui
    // 1 - Inserir um dado no fim de uma Lista Estática Circular.
    // 14 - Apagar um dado do fim de uma Lista Estática Circular.
    
    public void inserirNoFim(Object dado){
        if(!estaCheia()){
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            quantidade++;
        }else{
            System.err.println("List is Full!");
        }
    }

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

    private int retroceder(int ponteiro) {
        return ((ponteiro-1)+dados.length)%dados.length;
    }

    private int avancar(int ponteiro) {
        return (ponteiro+1)%dados.length;
    }
}