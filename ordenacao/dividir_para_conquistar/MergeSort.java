/**
 * Classe que implementa o algoritmo de ordenação Merge
 * 
 * @author Maria Eduarda Campos
 * @since 09-06-2025
 */
public class MergeSort {
    private Object[] dados; // O array de dados a ser ordenado

    /**
     * Construtor 
     *
     * @param dados array a ser ordenado.
     */
    public MergeSort(Object[] dados) {
        this.dados = dados;
    }

    /**
     * Método que ordena o array.
     */
    public void ordenar() {
        Object[] temp = new Object[dados.length]; 
        mergesort(temp, 0, dados.length - 1);
    }

    /**
     * Método recursivo principal do algoritmo.
     *
     * @param temp array temporário 
     * @param esquerda índice inicial do sub-array
     * @param direita índice final do sub-array
     */
    private void mergesort(Object[] temp, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergesort(temp, esquerda, meio); 
            mergesort(temp, meio + 1, direita); 

            intercalar(temp, esquerda, meio, direita); 
        }
    }

    /**
     * Método que intercala duas sub-partes ordenadas do array em uma única
     *
     * @param temp array temporário 
     * @param esquerda índice inicial da primeira metade a ser intercalada
     * @param meio índice final da primeira metade
     * @param direita índice final da segunda metade a ser intercalada
     */
    private void intercalar(Object[] temp, int esquerda, int meio, int direita) {
        for (int i = esquerda; i <= direita; i++) {
            temp[i] = dados[i];
        }

        int i = esquerda; 
        int j = meio + 1; 
        int k = esquerda; 

        while (i <= meio && j <= direita) {
            if ((Integer) temp[i] <= (Integer) temp[j]) {
                dados[k] = temp[i];
                i++;
            } else {
                dados[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            dados[k] = temp[i];
            i++;
            k++;
        }

        while (j <= direita) {
            dados[k] = temp[j];
            j++;
            k++;
        }
    }

    /**
     * Método que imprime o array ordenado.
     *
     * @return String contendo os elementos do array
     */
    public String imprimir() {
        String resultado = "[";
        for (int i = 0; i < dados.length; i++) {
            if (i == dados.length - 1) {
                resultado += dados[i];
            } else {
                resultado += dados[i] + ",";
            }
        }
        return resultado + "]";
    }
}