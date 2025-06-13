package test;

import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;
import main.*;

public class FilaDinamicaGenericaTest {

  @Test
  public void testFilaComDiferentesTipos() {
    Enfileiravel<Integer> filaInt = new FilaDinamicaGenerica<>();
    filaInt.enfileirar(1);
    assertEquals(Integer.valueOf(1),filaInt.frente());

    Enfileiravel<String> filaStr = new FilaDinamicaGenerica<>();
    filaStr.enfileirar("S");
    assertEquals("S",filaStr.frente());
  }

  @Test
  public void testConstrutorPadrao() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    for(int i = 0; i<10; i++){
      fila.enfileirar("A");
    }
    assertTrue(fila.estaCheia());
    fila.desenfileirar();
    
  }

  @Test
  public void testConstrutorComTamanhoPersonalizado() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>(15);
    for(int i = 0; i<15; i++){
      fila.enfileirar("A");
    }
    assertTrue(fila.estaCheia());
  }

  @Test
  public void testEnfileirar() {
  }

  @Test
  public void testDesenfileirar() {
  }

  @Test
  public void testDesenfileirarMultiplosElementos() {
  }

  @Test
  public void testFrente() {
  }

  @Test
  public void testAtualizarInicio() {
  }

  @Test
  public void testAtualizarInicioComMultiplosElementos() {
  }

  @Test
  public void testAtualizarFim() {
  }

  @Test
  public void testAtualizarFimComMultiplosElementos() {
  }

  @Test
  public void testImprimirDeFrentePraTras() {
  }

  @Test
  public void testImprimirDeFrentePraTrasVaziaFormatacaoVazia() {
  }
  
  @Test
  public void testImprimirDeFrentePraTrasFormatacao() {
  }

  @Test
  public void testEstaCheia() {
  }
  
  @Test
  public void testEstaVazia() {
  }

  @Test
  public void testFilaCheiaEnfileirar() {
  }
  
  @Test
  public void testFilaVaziaDesenfileirar() {
  } 

  @Test
  public void testFilaVaziaFrente() {
  }

  @Test
  public void testFilaVaziaAtualizarInicio() {
  }

  @Test
  public void testFilaVaziaAtualizarFim() {
  }
  
  @Test
  public void testOperacaoNaoSuportadaEnfileirarInicio() {
  }

  @Test
  public void testOperacaoNaoSuportadaDesenfileirarFim() {
  }

  @Test
  public void testOperacaoNaoSuportadaTras() {
  }

  @Test
  public void testOperacaoNaoSuportadaImprimirDeTrasPraFrente() {
  }

  @Test
  public void testLimpezaFila() {
  }
}

// javac -d bin (Get-ChildItem -Recurse -Filter "*.java" -Path src/main).FullName
// javac -d bin -cp "bin;lib/*" src/test/FilaDinamicaGenericaTest.java
// java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.FilaDinamicaGenericaTest