package ordenacao;

public class OrdSelection {
    int[] dados = {6,8,3,1,9,0,2,5};
    public static void main(String[] args) {
        OrdSelection sort = new OrdSelection();
        sort.imprimirTela();
        sort.ordenarSelection();
        sort.imprimirTela();
    }
    
    public void ordenarSelection(){
        for(int j = 0; j<dados.length; j++){
            int menor = j;
            for (int i = 1+j; i<dados.length; i++){
                if(dados[menor] > dados[i]){
                    menor = i;
                }
            }
            trocar(j, menor);
        }       
    }

    private void trocar(int indice1, int indice2){
        int aux = dados[indice1];
        dados[indice1] = dados[indice2];
        dados[indice2] = aux;
    }

    private void imprimirTela(){
        for(int dado : dados){
            System.out.print(dado + " ");
        }
        System.out.println();
    }
}
