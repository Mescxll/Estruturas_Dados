package pilha_estatica.pilha_dupla;

public class PilhaEstaticaDupla implements EmpilhavelDupla{
    private Object[] dados;
    private int ponteiroTopo1;
    private int ponteiroTopo2;

    public PilhaEstaticaDupla() { 
        this(10); 
    }

    public PilhaEstaticaDupla(int tamanho) {
        ponteiroTopo1 = -1;
        ponteiroTopo2 = tamanho;
        dados = new Object[tamanho];

    }

    @Override
    public void empilhar1(Object dado) {
        if(!estaCheia1()){
            ponteiroTopo1++;
            dados[ponteiroTopo1]=dado;
        }else{
            System.err.println("Stack is full!"); 
            //Criar excessão de OverFlow
        }
    }

    @Override
    public void empilhar2(Object dado) {
        if(!estaCheia2()){
            ponteiroTopo2--;
            dados[ponteiroTopo2]=dado;
        }else{
            System.err.println("Stack is full!"); 
            //Criar excessão de OverFlow
        }
    }
    
    @Override
    public Object desempilhar1() {
        Object aux = null;
        if(!estaVazia1()) {         
            aux = dados[ponteiroTopo1];
            ponteiroTopo1--;
        }else{
            System.err.println("Stack is empty!");   
            //Criar excessão de UnderFlow    
        }
        return aux;
    }

    @Override
    public Object desempilhar2() {
        Object aux = null;
        if(!estaVazia2()) {         
            aux = dados[ponteiroTopo2];
            ponteiroTopo2++;
        }else{
            System.err.println("Stack is empty!");   
            //Criar excessão de UnderFlow    
        }
        return aux;
    }

    @Override
    public Object espiar1() {
        Object aux = null;
        if(!estaVazia1()) {         
            aux = dados[ponteiroTopo1];
        }else{
            System.err.println("Stack is empty!");           
        }
        return aux;
    }

    @Override
    public Object espiar2() {
        Object aux = null;
        if(!estaVazia2()) {         
            aux = dados[ponteiroTopo2];
        }else{
            System.err.println("Stack is empty!");           
        }
        return aux;
    }

    public void atualizar1(Object dado) {
        if(!estaVazia1()){          
            dados[ponteiroTopo1]=dado;
        }else{
            System.err.println("Stack is empty!"); 
        }
    }

    public void atualizar2(Object dado) {
        if(!estaVazia2()) {
			dados[ponteiroTopo2] = dado;
		} else {
            System.err.println("Stack is empty!"); 
        }
    }

    @Override
    public boolean estaCheia1() {
        return (ponteiroTopo1 == ponteiroTopo2-1);
    }

    @Override
    public boolean estaCheia2() {
        return estaCheia1();
    }

    @Override
    public boolean estaVazia1() {
        return (ponteiroTopo1 == -1); 
    }

    @Override
    public boolean estaVazia2() {
        return (ponteiroTopo2 == dados.length); 
    }

    @Override 
    public String imprimir1() {
        String aux = "[";
        for(int i = ponteiroTopo1; i >= 0; i--){
            if(i == 0){
                aux += dados[i];
            }else{
                aux += dados[i] + ",";
            }
        } 
        return aux + "]";
    }

    @Override 
    public String imprimir2() {
        String aux = "[";
        for(int i = ponteiroTopo2; i <= dados.length-1; i++) {
            if (i == dados.length-1) {
                aux += dados[i];
            }else{
                aux += dados[i] + ",";
            }
        } 
        return aux + "]";
    }
}
