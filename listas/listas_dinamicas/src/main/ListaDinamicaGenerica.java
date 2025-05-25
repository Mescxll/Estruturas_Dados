package main;

public class ListaDinamicaGenerica<T> implements Listavel<T> {
    private int quantidade;
	private int tamanho;
	private NodoDuplo<T> ponteiroInicio;
	private NodoDuplo<T> ponteiroFim;

	public ListaDinamicaGenerica() {
		this(10);
	}

	public ListaDinamicaGenerica(int tamanho) {
		quantidade = 0;
		this.tamanho = tamanho;
		ponteiroInicio = null;
		ponteiroFim = null;
	}

    @Override
    public void anexar(T dado) {
        if(estaCheia())
            throw new OverFlowException("List is Full!");
        NodoDuplo<T> nodoTemp  = new NodoDuplo<>(dado);
        nodoTemp.setAnterior(ponteiroFim);
        ponteiroFim.setProximo(nodoTemp);
        ponteiroFim = nodoTemp;
        quantidade++;
    }

    @Override
    public void inserir(int posicao, T dado){
        // TODO Auto-generated method stub
        throw new OverFlowException("Unimplemented method 'inserir'");
    }

    @Override
    public T selecionar(int posicao) {
        if(estaVazia())
            throw new UnderFlowException("List is Empty!");
        if(posicao <0 || posicao>=quantidade)
            throw new IndexOutOfBoundsException("Indice inválido!");
        NodoDuplo<T> nodoAux = ponteiroInicio;
        for(int i = 0; i< posicao; i++){
            nodoAux = nodoAux.getProximo();
        }
        return nodoAux.getDado();
    }

    @Override
    public T[] selecionarTodos() {
        if(estaVazia())
            throw new UnderFlowException("List is Empty!");
        Object[] arrayAux = new Object[quantidade];
        NodoDuplo<T> nodoAux = ponteiroInicio;
        for(int i = 0; i< quantidade; i++){
            arrayAux[i] = nodoAux.getDado();
            nodoAux = nodoAux.getProximo();
        }
        return (T[]) arrayAux;
    }

    @Override
    public void atualizar(int posicao, T novoDado) {
        if(estaVazia())
            throw new UnderFlowException("List is Empty!");
        if(posicao <0 || posicao>=quantidade)
            throw new IndexOutOfBoundsException("Indice inválido!");
        if(posicao == quantidade-1){
            ponteiroFim.setDado(novoDado);
            return;
        }
        NodoDuplo<T> nodoAux = ponteiroInicio;
        for(int i = 0; i< posicao; i++){
            nodoAux = nodoAux.getProximo();
        }
        nodoAux.setDado(novoDado);
        
        
    }

    @Override
    public T apagar(int posicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apagar'");
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }
    
}
