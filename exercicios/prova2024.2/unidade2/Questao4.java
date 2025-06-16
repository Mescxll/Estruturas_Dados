package unidade2;

import java.util.NoSuchElementException;

public class Questao4 {
    private static long contadorPrioridade = 0;

    //Questao 4
    public long ajustarPrioridade(int valor){
        long nanoTime = System.nanoTime();
        
        Questao4.contadorPrioridade++;
        
        return (long) valor * 1_000_000_000_000_000L + 
                                    nanoTime + contadorPrioridade;
    }
}
