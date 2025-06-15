package ordenacao;

public class OrdBubble{
    int[] dados = {6,8,3,1,9,0,2,5};
    public static void main(String[] args) {
        OrdBubble sort = new OrdBubble();
        sort.imprimirTela();
        sort.ordenarBubble();
        sort.imprimirTela();
    }

    public void ordenarBubble(){
        for(int j = 0; j < dados.length-1; j++){  
            for(int i = 0; i < (dados.length-1)-j; i++){
                if(dados[i+1] < dados[i]){
                   trocar(i, i+1);
                }
            }
        }
    }

    private void trocar(int indice1, int indice2){
        int aux = dados[indice1];
        dados[indice1] = dados[indice2];
        dados[indice2] = aux;
    }

    public void imprimirTela(){
        for(int dado : dados){
            System.out.print(dado + " ");
        }
        System.out.println();
    }
}