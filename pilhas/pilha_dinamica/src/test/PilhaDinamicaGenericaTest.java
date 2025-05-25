package test;

import main.Empilhavel;
import main.PilhaDinamicaGenerica;

public class PilhaDinamicaGenericaTest {
    
    @Test
    public void testEmpilhar(){
        Empilhavel<Integer> pilha = new PilhaDinamicaGenerica<>();
        pilha.empilhar(1);
        System.out.println(pilha.imprimir());
    }

    @Test
    public void testDesenfileirar(){

    }
}

//compilar .jar na pasta bin: javac -cp "lib/*" -d bin src/*.java test/*.java

//Meu
//rodar testes: java -cp "lib/*;bin" org.junit.runner.JUnitCore pilha_dinamica.test.PilhaDinamicaGenericaTest
//Claudio
//executar teste: java -cp.;bin;test;lib;junit-4.10.jar org.junit.runner.JUnitCore PilhaDinamicaGenrericaTest

//Compilar de Claudio
// javac -cp .;bin;lib/junit-4.13.2.jar -d test test/PilhaDinamicaGenericaTest.java
// Meu compilar
// javac -cp ".;bin;lib/junit-4.13.2.jar" -d bin test/PilhaDinamicaGenericaTest.java