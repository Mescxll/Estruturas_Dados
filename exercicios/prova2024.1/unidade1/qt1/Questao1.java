package qt1;

public interface Questao1 {
    //Controle de itens em um catálogo de produtos.
    
    //Adicionar Produto no catálogo
    void anexarProduto(Produto produto);
    //Adicionar produto em página específica
    void inserirProduto(Produto produto, int indice);

    //Verifica preço de um produto pelo nome
    Double verificarPreco(Produto produto);

    //Verifica quantidade de um produto no estoque pelo nome
    int verificarEstoque(Produto produto);

    //Remover produto do catálogo
    Produto apagarProduto(int indice);
    
    //Selecionar um produto
    Produto selecionarProduto(Produto produto);
    //Selecionar todos os produto
    Produto[] selecionarTodos();

    //Verificar se o catálogo está cheio ou vazio
    boolean estaVazio();
    boolean estaCheio();

    //Verificar se determinado produto está no catálogo
    boolean contem(Produto Produto);

    //Limpa o catálogo
    void limpar();

    //Imprimir catálogo
    String imprimirCatalogo();
}

class Produto{

}
