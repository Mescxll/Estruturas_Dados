# Fila

- Fila(Queue)
- Fila Cicular(Cycle Queue)
- Fila com Dupla Terminação

```
Fila ------------------------------------
|       |   A   |  B    |    C  |       |      
-----------------------------------------
          inicio           fim
```

Quem chega vai para o fim. Quem entra primeiro, sai primeiro. (FIFO)

Característica: Enfileirável

```
enfileirar ->     C REATE (enqueue)

frente ->         R EAD (front)

atualizar ->      U PDATE (update)

desenfileirar ->  D ELETE (dequeue)
```

### Ordem de Complexidade

0(1) - tempo para acessar ou processar qualquer elemento da estrutura de dados é constante

0(n) - tempo para acessar ou processar qualquer elemento da estrutura de dados depende diretamente do número de elementos na estrutura(linear)

### Lógica de circularidade: 
Se x<y: x % y = x sempre.
