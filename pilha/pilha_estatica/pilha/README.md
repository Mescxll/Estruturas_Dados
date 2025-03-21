# Anotações de Aula - ED 2025.1

```
PILHA (STACK)
------------
|          | 4
------------
|          | 3
------------
|     C    | 2 -> Ponteiro Topo
------------
|     B    | 1 
------------
|     A    | 0
------------
    -1 -> Ponteiro Topo = pilha vazia.
```


- A Interface define o comportamento da classe que a implementa -> conjunto de operações que a classe deve propor 
- Usa-se object para coisas gerais, mas é possivel usar outros tipos mais adequados para coisas especificas. Ex: Strings para músicas
- A classe da pilha pode ser divida em: Variáveis de instância e Métodos
- Métodos podem ser divididos em Construtores, Auxiliares e Principais.
- int quantidade; e int tamanho; são exemplos de atributos que podem ser utilizados, porém no caso são dispensáveis
- O construtor não possui retorno, mas de maneira intrínseca retorna a Classe, no caso 'PilhaEstatica'
- O this(); pode ser utilizado para chamar um construtor dentro de outro construtor.
- System.err.println(""); -> Direcionar saídas -> Mensagem de erro
- É mais indicado (boa prática) criar um objeto por meio de sua interface ao invés da classe concreta (ex: criar um ArrayList), a menos que precise utilizar métodos que estão apenas na classe concreta.   