# Anotações de Aula - ED 2025.1 - Árvore Binária HEAP

### Caracterísicas
- Árvore Binária HEAP -> Completa a esquerda, nunca vai ter buracos a esquerda.
- Usadas na elaboração de Filas de Prioridade.

```
Completa a esquerda:   
        (A)             
        / \                         
    (B)     (C)        
    /          
(D)

Não completa a esquerda:   
        (A)
        / \
    (B)     (C)
               \
                (D) 
```

### MAX e MIN Heap
MIN-HEAP -> Nó genitor menor ou igual do que seus filhos

MAX-HEAP -> Nó genitor maior ou igual do que seus filhos 

```
Ex de árvore (MAX):
  
        (5)    -> nó raiz               (4)
        / \                             / \     -> Sub-árvore
    (4)     (3) -> folha/filho        (2) (1)
    / \         
(2)    (1)

Ex de árvore (MIN):

        (1)    -> nó raiz               (2)
        / \                             / \     -> Sub-árvore
    (2)     (3) -> folha/filho        (4) (5)
    / \         
(4)    (5)
```
### Inserção

```
-----------       Árvore
|0|1|2|3|4|  ->     0
-----------        / \
                  1   2
                 / \
                3   4
```

### Ordenação (MAX)

```
-------------     Árvore         Ordenada    -------------
|7|9|1|22|15|  ->   7               22  <-   |22|15|1|9|7|
-------------      / \             /  \      -------------
                  9   1           15   1
                 / \             / \
                22  15          9   7
```

- Métodos: 

    - int indiceGenitor(int filho)    -> return (filho - 1) / 2

    - int filhoEsquerdo(int pai)      -> return (pai * 2) + 1

    - int filhoDireito(int pai)       -> return (pai * 2) + 2

### Teoria da Inserção e Remoção (MAX)

```
           Inserção    Remoção
              /             \
         baixo/cima      cima/baixo
```

- Remoção sempre da Raiz -> Põe o último no começo -> Ordena novamente
