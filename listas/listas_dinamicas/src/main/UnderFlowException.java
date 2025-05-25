package main;

public class UnderFlowException extends RuntimeException{
    public UnderFlowException(){
        super();
    }
    public UnderFlowException(String msg){
        super(msg);
    }
}
