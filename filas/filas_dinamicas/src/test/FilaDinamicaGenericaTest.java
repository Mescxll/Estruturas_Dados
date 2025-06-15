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
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>(2);
    fila.enfileirar("A");
    assertEquals("A", fila.frente());
    assertFalse(fila.estaVazia());

    fila.enfileirar("B");
    assertEquals("A", fila.frente()); 
    assertTrue(fila.estaCheia()); 

  }

  @Test
  public void testDesenfileirar() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    fila.enfileirar("A");
    fila.enfileirar("B");
    fila.desenfileirar();
    assertEquals(fila.frente(), "B");
    fila.desenfileirar();
    assertTrue(fila.estaVazia());
  }

  @Test
  public void testDesenfileirarMultiplosElementos() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    fila.enfileirar("A");
    fila.enfileirar("B");
    fila.enfileirar("C");
    fila.enfileirar("D");
    fila.desenfileirar();
    fila.desenfileirar();
    fila.desenfileirar();
    assertTrue(fila.frente() == "D");
    fila.desenfileirar();
    assertTrue(fila.estaVazia());
  }

  @Test
  public void testFrente() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    fila.enfileirar("A");
    fila.enfileirar("B");
    assertEquals(fila.frente(),"A");
    fila.desenfileirar();
    assertEquals(fila.frente(),"B");
  }

  @Test
  public void testAtualizarFim() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    fila.enfileirar("A");
    assertEquals("A", fila.frente()); 
    fila.atualizarFim("Z");
    assertEquals("Z", fila.frente()); 
    fila.desenfileirar();
    assertTrue(fila.estaVazia());
  }

  @Test
  public void testAtualizarFimComMultiplosElementos() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    fila.enfileirar("A");
    fila.enfileirar("B");
    fila.enfileirar("C"); 
    assertEquals("A", fila.frente());
    fila.atualizarFim("Y");
    assertEquals("A", fila.frente());
    fila.desenfileirar(); 
    assertEquals("B", fila.frente());
    fila.desenfileirar(); 
    assertEquals("Y", fila.frente());
    fila.desenfileirar();
    assertTrue(fila.estaVazia());
  }

  @Test
  public void testImprimir() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    fila.enfileirar("A");
    fila.enfileirar("B");
    fila.enfileirar("C");
    assertEquals("[A, B, C]", fila.imprimir());
  }

  @Test
  public void testImprimirFormatacaoVazia() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    assertEquals("[]", fila.imprimir());
  }
  
  @Test
  public void testImprimirFormatacao() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    fila.enfileirar("A");
    assertEquals("[A]", fila.imprimir());
    fila.desenfileirar(); 

    fila.enfileirar("Item1");
    fila.enfileirar("Item2");
    fila.enfileirar("Item3");

    assertEquals("[Item1, Item2, Item3]", fila.imprimir());
    fila.desenfileirar(); 
    assertEquals("[Item2, Item3]", fila.imprimir());
    fila.desenfileirar(); 
    assertEquals("[Item3]", fila.imprimir());
    fila.desenfileirar(); 

    assertEquals("[]", fila.imprimir());
  }

  @Test
  public void testEstaCheia() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>(1);
    assertFalse(fila.estaCheia());
    fila.enfileirar("A");
    assertTrue(fila.estaCheia());
  }
  
  @Test
  public void testEstaVazia() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    assertTrue(fila.estaVazia());
    fila.enfileirar("A");
    assertFalse(fila.estaVazia());
  }

  @Test
  public void testFilaCheiaEnfileirar() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>(1); 
    fila.enfileirar("A"); 
    assertThrows(NoSuchElementException.class, () -> fila.enfileirar("B"));
  }
  
  @Test
  public void testFilaVaziaDesenfileirar() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    assertThrows(NoSuchElementException.class, () -> fila.desenfileirar());
  } 

  @Test
  public void testFilaVaziaFrente() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>();
    assertThrows(NoSuchElementException.class, () -> fila.frente());
  }

  @Test
  public void testFilaVaziaAtualizarFim() {
    Enfileiravel<String> fila = new FilaDinamicaGenerica<>(); 
    assertThrows(NoSuchElementException.class, () -> fila.atualizarFim("Y"));
  }
}

// javac -d bin (Get-ChildItem -Recurse -Filter "*.java" -Path src/main).FullName
// javac -d bin -cp "bin;lib/*" src/test/FilaDinamicaGenericaTest.java
// java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.FilaDinamicaGenericaTestjavac -d bin -cp "bin;lib/*" src/test/FilaDinamicaGenericaTest.java