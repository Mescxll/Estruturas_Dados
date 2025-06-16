

public class Tarefas {
    private static int id_generator = 1;
    private int ID;
    private String descricao;
    private int prioridade;
   
    public Tarefas(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.ID = id_generator++;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return descricao;
    }

    
}
