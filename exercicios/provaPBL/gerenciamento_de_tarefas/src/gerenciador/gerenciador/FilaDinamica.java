
import java.util.NoSuchElementException;

public class FilaDinamica implements Enfileiravel{
    private NoDuplo ponteiroFim;
    private NoDuplo ponteiroInicio;
    private int tamanho;
    private int quantidade;
    
    public FilaDinamica(int tamanho) {
        this.quantidade = 0;
        this.tamanho = tamanho;
    }

    public FilaDinamica() {
        this.quantidade = 0;
        this.tamanho = 15;
    }
    
    @Override
    public void enfileirar(Tarefas dado){
        if(estaCheia()){
            throw new NoSuchElementException("Fila Cheia"); 
        }

        NoDuplo nodo = new NoDuplo(dado);
        
        if(quantidade==0){
            ponteiroInicio = nodo;
            ponteiroFim = nodo;
        }else{
            ponteiroFim.setPosterior(nodo);
            nodo.setAnterior(ponteiroFim);
            ponteiroFim = nodo;
        }
        quantidade++;
    }

    @Override
    public Tarefas desenfileirar(){
        if (estaVazia()) {
            throw new NoSuchElementException("Fila Vazia");
        }
        NoDuplo nodo = ponteiroInicio;
        nodo = ponteiroInicio;

        if(quantidade!=1){
            ponteiroInicio = ponteiroInicio.getPosterior();
            ponteiroInicio.setAnterior(null);
        }else{
            ponteiroInicio = null;
            ponteiroFim = null;
        }
        
        quantidade--;

        return nodo.getDado();
    }

    @Override
    public Tarefas frente(){
        if (estaVazia()) {
            throw new NoSuchElementException("Fila Vazia");
        }
        return ponteiroInicio.getDado();
    }

    @Override
    public void atualizar(Tarefas dado){
        if (estaVazia()) {
            throw new NoSuchElementException("Fila Vazia");
        }
        ponteiroInicio.setDado(dado);
    }

    @Override
    public boolean estaCheia(){
        return tamanho == quantidade;
    }
    
    @Override
    public boolean estaVazia(){
        return quantidade == 0;
    }
    
    @Override
    public String imprimir(){
        String aux = "[";
        NoDuplo ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            aux += ponteiroAux.getDado();
            if (i != quantidade - 1)
                aux += ", ";
            ponteiroAux = ponteiroAux.getPosterior();
        }
        return aux + "]";
    }
    
}
