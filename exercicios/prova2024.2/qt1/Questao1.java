/*Defina uma interface em Java com as operações necessárias (nome da 
operação, parâmetros de entrada e tipo de retorno(se necessário)) e a 
descrição destas operações, para implementar um organizador de receitas 
culinárias,utilizando a estrutura de dados do tipo Lista. É necessário 
a gerência de uma lista de receitas com ingredientes, modos de preparo 
e categorias como "favoritas" ou "testadas".  */

public interface Questao1{
    //Organizador de receitas culinárias

    void anexarReceita(Receita receita);
    void inserirReceita(Receita receita, int indice);

    Receita excluirReceita(Receita receita);
    Receita apagarReceita(int indice);

    void marcarComoReceitaFavorita(Receita receita);
    void marcarComoReceitaTestada(Receita receita);
    
    boolean contem(Receita receita);
    boolean estaVazia();
    boolean estaCheia();

    Receita selecionar(int indice);                 
    Receita[]selecionarTodas();  

    void limpar();

    String imprimir();
    
}
