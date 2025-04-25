package ordenacao;

public class OrdInsertion {
    int[] dados = {6,8,3,1,9,0,2,5};
    public static void main(String[] args) {
        OrdInsertion sort = new OrdInsertion();
        sort.imprimirTela();
        sort.ordenarInsertion();
        sort.imprimirTela();
    }

    public void ordenarInsertion(){
        for (int pivo = 1; pivo < dados.length; pivo++) {
            for (int i = pivo-1; i >= 0; i--) {
                if(dados[i+1] < dados[i]){
                    trocar(i, i+1);
                }else{
                    break;
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
