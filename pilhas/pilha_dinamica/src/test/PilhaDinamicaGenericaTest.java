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

//compilar .jar na pasta bin: javac -cp "lib/*" -d bin src/*.java test/*.java

//Meu
//rodar testes: java -cp "lib/*;bin" org.junit.runner.JUnitCore pilha_dinamica.src.test.PilhaDinamicaGenericaTest
//Claudio
//executar teste: java -cp.;bin;test;lib;junit-4.10.jar org.junit.runner.JUnitCore PilhaDinamicaGenrericaTest

//Compilar de Claudio
// javac -cp .;bin;lib/junit-4.13.2.jar -d test test/PilhaDinamicaGenericaTest.java
// Meu compilar
// javac -cp ".;bin;lib/junit-4.13.2.jar" -d bin src/test/PilhaDinamicaGenericaTest.java

// javac -cp ".;bin;lib/junit-4.13.2.jar" -d bin src/test/PilhaDinamicaGenericaTest.java

// javac -cp ".;lib/junit-4.13.2.jar" -d bin src/test/PilhaDinamicaGenericaTest.java
