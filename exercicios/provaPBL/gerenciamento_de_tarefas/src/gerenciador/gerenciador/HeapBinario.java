
import java.util.NoSuchElementException;


public class HeapBinario implements Amontoavel{
    private Tarefas[] heapTarefas;
    private int ponteiro;
    private FilaDinamica concluidas;

    public HeapBinario(int tamanho) {
        concluidas = new FilaDinamica(tamanho);
        this.heapTarefas = new Tarefas[tamanho];
        this.ponteiro = -1;
    }

    public HeapBinario() {
        this(15);
    }

    @Override
    public void amontoar(Tarefas tarefa) {
        if(estaCheia()){
            throw new NoSuchElementException("Heap Cheio");
        }
        ponteiro++;
        heapTarefas[ponteiro] = tarefa;
        ajustarAcima(ponteiro);
    }

    @Override
    public Tarefas extrair() {
        if (estaVazia()) {
            throw new NoSuchElementException("Heap Vazio");
        }
        Tarefas tarefa = heapTarefas[0]; 
        concluidas.enfileirar(tarefa); 
        heapTarefas[0] = heapTarefas[ponteiro];
        ponteiro--; 

        if (ponteiro != -1) { 
            ajustarAbaixo(0);
        }
        return tarefa;
    }

    @Override
    public Tarefas espiar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Heap Vazio");
        }
        return heapTarefas[0];
    }

    private void ajustarAcima(int ponteiro) {
        int indiceFilho = ponteiro;
        int indicePai;

        while (indiceFilho != 0) {
            indicePai = indicePai(indiceFilho);

            if (heapTarefas[indiceFilho].getPrioridade() > heapTarefas[indicePai].getPrioridade()) {
                trocar(indicePai, indiceFilho);
            } else {
                break;
            }
            indiceFilho = indicePai;
        }
    }

    private void ajustarAbaixo(int ponteiro) {
        int indicePai = ponteiro;
        int indiceFilhoEsquerdo;
        int indiceFilhoDireito;
        int indiceMaiorFilho; 

        while (indicePai * 2 + 1 <= this.ponteiro) {
            indiceFilhoEsquerdo = indiceFilhoEsquerdo(indicePai);
            indiceFilhoDireito = indiceFilhoDireito(indicePai);
            indiceMaiorFilho = indiceFilhoEsquerdo; 

            if (indiceFilhoDireito <= this.ponteiro &&
                    heapTarefas[indiceFilhoDireito].getPrioridade() > heapTarefas[indiceFilhoEsquerdo]
                            .getPrioridade()) {
                indiceMaiorFilho = indiceFilhoDireito; 
            }

            if (heapTarefas[indicePai].getPrioridade() < heapTarefas[indiceMaiorFilho].getPrioridade()) {
                trocar(indicePai, indiceMaiorFilho);
                indicePai = indiceMaiorFilho;
            } else {
                break;
            }
        }
    }

    private int indicePai(int filho){
        return (filho - 1) / 2;
    }

    private int indiceFilhoEsquerdo(int pai) {
        return pai * 2 + 1;
    }

    private int indiceFilhoDireito(int pai) {
        return pai * 2 + 2;
    }

    private void trocar(int a, int b){
        Tarefas aux = heapTarefas[a];
        heapTarefas[a] = heapTarefas[b];
        heapTarefas[b] = aux;
    }

    @Override
    public boolean estaCheia() {
        return ponteiro == heapTarefas.length - 1;
    }

    @Override
    public boolean estaVazia() {
        return ponteiro == -1;
    }

    @Override
    public String imprimir() {
        String aux = "[";
        for(int i = 0; i<=ponteiro; i++){
            if(i!=ponteiro)
                aux+=heapTarefas[i] + ", ";
            else
                aux+=heapTarefas[i];
        }
        return aux+"]";
    }
    
    public String imprimirConcluidas(){
        return concluidas.imprimir();
    }
    
}
