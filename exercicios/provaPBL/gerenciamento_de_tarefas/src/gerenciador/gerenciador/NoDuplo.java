
public class NoDuplo {
    private NoDuplo nodoAnterior;
    private NoDuplo nodoPosterior;
    private Tarefas dado;

    public NoDuplo(Tarefas dado){
        this.dado = dado;
    }

    public NoDuplo getAnterior() {
        return nodoAnterior;
    }

    public void setAnterior(NoDuplo nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public NoDuplo getPosterior() {
        return nodoPosterior;
    }

    public void setPosterior(NoDuplo nodoPosterior) {
        this.nodoPosterior = nodoPosterior;
    }

    public Tarefas getDado() {
        return dado;
    }

    public void setDado(Tarefas dado) {
        this.dado = dado;
    }
}
