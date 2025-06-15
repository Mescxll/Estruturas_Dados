package main;

/**
 * Código referente a implementação de uma lista dinâmica genérica
 * feito na aula de Estrutura de Dados.
 * 
 * @author Maria Eduarda Campos
 * @version 3.0
 * @since 25-05-2025
 */
public class ListaDinamicaGenerica<T> implements Listavel<T> {
    private int quantidade;
	private int tamanho;
	private NodoDuplo<T> ponteiroInicio;
	private NodoDuplo<T> ponteiroFim;

    /**
     * Construtor vazio
     */
	public ListaDinamicaGenerica() {
		this(10);
	}

    /**
     * Construtor 
     */
	public ListaDinamicaGenerica(int tamanho) {
		quantidade = 0;
		this.tamanho = tamanho;
		ponteiroInicio = null;
		ponteiroFim = null;
	}

    /**
     * Métod que anexa um dado ao final da lista.
     *
     * @param dado O dado a ser anexado.
     * @throws OverFlowException Se a lista estiver cheia.
     */
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

    /**
     * Método que Insere um dado em uma posição específica da lista.
     *
     * @param posicao A posição onde o dado será inserido.
     * @param dado    O dado a ser inserido.
     * @throws OverFlowException Método não implementado.
     */
    @Override
    public void inserir(int posicao, T dado){
        // TODO Auto-generated method stub
        throw new OverFlowException("Unimplemented method 'inserir'");
    }

    /**
     * Método que seleciona e retorna o dado em uma posição específica da lista.
     *
     * @param posicao A posição do dado a ser selecionado.
     * @return T O dado na posição especificada.
     * @throws UnderFlowException        Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
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

    /**
     * Método que retorna todos os elementos da lista em um array.
     *
     * @return T[] Um array contendo todos os elementos da lista.
     * @throws UnderFlowException Se a lista estiver vazia.
     */
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

    /**
     * Método que atualiza o dado em uma posição específica da lista.
     *
     * @param posicao  A posição do dado a ser atualizado.
     * @param novoDado O novo dado a ser definido.
     * @throws UnderFlowException        Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
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

    /**
     * Apaga um elemento de uma posição específica da lista.
     *
     * @param posicao A posição do elemento a ser apagado.
     * @throws UnsupportedOperationException Método não implementado.
     * @return T O elemento apagado.
     */
    @Override
    public T apagar(int posicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apagar'");
    }

    /**
     * Limpa a lista, removendo todos os seus elementos.
    */
    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
    }

    /**
     * Método que verifica se a lista está cheia
     * 
     * @return True se estiver cheia e false caso contrário
     */
    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    /**
     * Método que verifica se a lista está vazia
     * 
     * @return True se estiver vazia e false caso contrário
     */
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    /**
     * Método para imprimir conteúdo da lista
     * 
     * @return String com o conteúdo
     * @throws UnsupportedOperationException Método não implementado.
     */
    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }
    
}
