package pilha_dinamica.test;

import pilha_dinamica.src.Empilhavel;
import pilha_dinamica.src.PilhaDinamicaGenerica;

public class PilhaDinamicaGenericaTest {
    
    //@Test
    public void testEmpilhar(){
        Empilhavel<Integer> pilha = new PilhaDinamicaGenerica<>();
        pilha.empilhar(1);
    }
}

//compilar teste: javac -cp.;bin;lib/junit-4.10.jar -d test test/PilhaDinamicaGenericaTest.java
//executar teste: java -cp.;bin;test;lib;junit-4.10.jar org.junit.runner.JUnitCore PilhaDinamicaGenrericaTest
