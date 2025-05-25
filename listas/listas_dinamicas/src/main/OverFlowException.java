package main;

public class OverFlowException extends RuntimeException{
    public OverFlowException(){
        super();
    }
    public OverFlowException(String msg){
        super(msg);
    }
}
