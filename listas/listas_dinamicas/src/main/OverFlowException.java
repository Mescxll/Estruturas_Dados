package main;

/**
 * Exceção lançada para indicar que uma operação resultou em um estouro de
 * capacidade (overflow).
 *
 * @author Maria Eduarda Campos
 */
public class OverFlowException extends RuntimeException{
    /**
     * Construtor padrão9
     */
    public OverFlowException(){
        super();
    }

    /**
     * Construtor para OverFlowException com uma mensagem detalhada.
     *
     * @param msg A mensagem de detalhes.
     */
    public OverFlowException(String msg){
        super(msg);
    }
}
