package test;

import main.Empilhavel;
import main.PilhaDinamicaGenerica;
import org.junit.Test;
import static org.junit.Assert.*;

public class PilhaDinamicaGenericaTest {
    @Test
    public void testEmpilhar(){
        Empilhavel<Integer> pilha = new PilhaDinamicaGenerica<>();
        pilha.empilhar(1);
        assertEquals("[1]", pilha.imprimir());
    }

    @Test
    public void testDesenfileirar(){
        Empilhavel<Integer> pilha = new PilhaDinamicaGenerica<>();
        pilha.empilhar(1);
        pilha.desempilhar(); 
        assertTrue(pilha.estaVazia());
    }
}

// javac -d bin -cp "bin;lib/*" src/test/PilhaDinamicaGenericaTest.java
// java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.PilhaDinamicaGenericaTest