package listas;

public interface Listavel {
    //Operações
    //C inserir e anexar
    //R selecionar, selecionar todos e contém
    //U atualizar
    //D apagar e limpar

    void inserir(Object dado, int posicao);         //insert
    void anexar(Object dado);                       //append
    Object selecionar(int posicao);                 //select
    Object[]selecionarTodos();                      //select all
    void atualizar(Object dado, int posicao);       //update
    Object apagar(int posicao);                     //delete

    boolean contem(Object dado);                    
    
    //Extras
    //int primeiraOcorrencia(Object dado); //Quando não existe retorna -1
    //int ultimaOcorrencia(Object dado);
    //void limpar();

    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}


