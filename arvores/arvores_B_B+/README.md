# Árvores B e B+ - Anotações de Aula

### Características

Os Nós das ávores B e B+ são chamados de páginas. Elas são árvores N-ária - múltiplos filhos.
Ambas são pecorridas 'Em ordem'.

Valores Máximos ->

Definição de ordem e número máximo de elementos por página:
```
_________________________________________________
| P | dado | P | dado | P | dado | P | dado | P | -> Se Ordem 5, a página pode no máximo 4 elementos
-------------------------------------------------
P = ponteiros
```

Ou seja => 
```
máximo  =  ordem - 1
```

Valores Mínimos -> (n/2)-1 
1. Ordem 2 -> ⌈2/2⌉−1 -> 1−1 -> 0
2. Ordem 3 -> ⌈3/2⌉−1 -> 2−1 -> 1
3. Ordem 4 -> ⌈4/2⌉−1 -> 2−1 -> 1
4. Ordem 5 -> ⌈5/2⌉−1 -> 3−1 -> 2
5. Ordem 6 -> ⌈6/2⌉−1 -> 3−1 -> 2
...

### Que valor mover?

#### Árvores B
- Se o conjunto for par - maior da esquerda
- Se o conjunto for ímpar - central

#### Árvores B+
- Se o conjunto for par - menor da direita
- Se o conjunto for ímpar - central


### Inserção em árvore B

[3, 5, 7, 9, 1, 8, 6, 10] - ordem 5

```
3 ->
            |3|

5 ->
            |3|5|

7 ->
            |3|5|7|

9 ->
            |3|5|7|9|

1 ->
            |5|
           /   \
      |1|3|     |7|9|

8 ->
            |5|
           /   \
      |1|3|     |7|8|9|

6 ->
            |5|
           /   \
      |1|3|     |6|7|8|9|

10 ->
             |5|8|
           /   |   \
      |1|3|  |6|7|  |9|10|
```
### Remoção em árvore B

CONCATENAÇÃO e REDISTRIBUIÇÃO

### Inserção em árvore B+

[10, 20, 30, 40, 50, 60, 80, 70, 100, 120, 130] - Ordem 5

```
10,20,30,40 - > |10|20|30|40|

50 ->       |30|
            /  \
     |10|20| -> |30|40|50|

60 ->       |30|
            /  \
     |10|20| -> |30|40|50|60|

80 ->        |30|50|
           /    |    \
    |10|20|->|30|40|->|50|60|80|

70 ->        |30|50|
           /    |    \
    |10|20|->|30|40|->|50|60|70|80|

100 ->     | 30 |   50   | 70 |
          /     |        |     \
    |10|20|->|30|40|->|50|60|->|70|80|100|

120 ->     | 30 |   50   | 70 |
          /     |        |     \
    |10|20|->|30|40|->|50|60|->|70|80|100|120|

130 ->     | 30 |   50   |   70   | 100 |
          /     |        |        |     \
    |10|20|->|30|40|->|50|60|->|70|80|->|100|120|130|
```

### Tópicos avulsos

X/2 -> Arrendondamento para baixo
Math.round
floor
ceil
n/2
n-1
```
                8 
            2 5   11 16 
0 1    3 4   6 7 9 10    12 15    17 18
```