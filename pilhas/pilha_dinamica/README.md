# Anotações de Aula - ED 2025.1 - Nodos e boas práticas

### Documentação
Documentar paramêtros, retornos e excessões sempre que necessário.

Cabeçalho de códigos:
```
  /**
  * Descrição
  * @author Autor 
  * @version Versão 
  * @since Data 
  */
```
### Artefatos
- /src
- /bin
- /build
- /test
- /lib

### Comandos

- Documentação
```
javadoc -d doc src/*.java -> gerar documentação a partir do que fazemos no código fonte
```
- Compilação e execução
```
javac src/*.java -d bin -> compilar arquivos fonte na pasta bin
java -cp .;bin PilhaDinamicaGenericaMainCLI -> executar o programa 
```
- Testes Unitários
```
javac -cp .;bin;lib/junit-4.13.2.jar -d test test/PilhaDinamicaGenericaTest.java -> compilar classe de teste
java -cp .;bin;test;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore PilhaDinamicaGenericaTest -> executar testes 
```
- Jar
```
jar cvfe build/Main.jar PilhaDinamicaGenericaMainCLI -C bin . -> gerar .jar
java -jar build/Main.jar -> executar .jar
```

### Objetos Ligados (Nodos)

Dentro de um espaço eu tenho um dado e um ponteiro -> Objetos ligados -> Nodo 

- Simplesmente ligada ou ligada ou encadeada (única ligação)
- Duplamente ligada ou duplamente encadeada
```
Nodo -> encadeado
Nodo Duplo -> duplamente encadeado

Duplamente encadeado:
----------------------
|---- ---------- ----|
||  | |        | |  ||  Tipos em um Nodo Duplo:                                          
||At| |  Dado  | |Px||  Dado = genérico
||  | |        | |  ||  Ponteiros (anterior e próximo) = Nodos duplos
|---- ---------- ----|
----------------------

Simplesmente encadeado:

-----------------
|---- ----------|
||  | |        ||
||At| |  Dado  ||
||  | |        ||   
|---- ----------|
-----------------
```
