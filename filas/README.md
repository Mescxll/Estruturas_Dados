# Fila

Fila(Queue)
Fila Cicular(Cycle Queue)
Fila com Dupla Terminação

```
Fila ------------------------------------
|       |   A   |  B    |    C  |       |      
-----------------------------------------
          inicio           fim
```

Quem chega vai para o fim. Quem entra prmeiro, sai primeiro. (FIFO)

Caracteristica: Enfileiravel

```
enfileirar ->     C REATE (enqueue)

frente ->         R EAD (front)

atualizar ->      U PDATE (update)

desenfileirar ->  D ELETE (dequeue)
```

O tempo cresce linearmente
O tempo para chegar em qualquer elemento é o mesmo : Ordem de Complexidade
0(1)
0(n)

### Lógica de circularidade: 
Se x<y: x % y = x sempre.