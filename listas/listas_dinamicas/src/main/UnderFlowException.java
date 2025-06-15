package main;

/**
 * Exceção lançada para indicar que uma operação resultou em um esvaziamento
 * indevido(underflow).
 * 
 * @author Maria Eduarda Campos
 */
public class UnderFlowException extends RuntimeException{
    /**
     * Construtor padrão
     */
    public UnderFlowException(){
        super();
    }

    /**
     * Construtor para UnderFlowException com uma mensagem detalhada.
     *
     * @param msg A mensagem de detalhes. 
     */
    public UnderFlowException(String msg){
        super(msg);
    }
}
