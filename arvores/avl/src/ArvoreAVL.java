public class ArvoreAVL<T extends Comparable<T>> implements Arborivel<T> {

    private NodoTriplo<T> raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    private int balanceamento(NodoTriplo<T> nodo) {
        return nodo != null
                ? altura(nodo.getFilhoDireito()) - altura(nodo.getFilhoEsquerdo())
                : 0;
    }

    private void atualizaAltura(NodoTriplo<T> nodo) {
        int maiorAltura = Math.max(altura(nodo.getFilhoEsquerdo()),
                altura(nodo.getFilhoDireito()));
        nodo.setAltura(maiorAltura + 1);
    }

    private int altura(NodoTriplo<T> no) {
        return no != null ? no.getAltura() : 0;
    }

    private NodoTriplo<T> aplicarRotacao(NodoTriplo<T> no) {
        NodoTriplo<T> novaRaiz;
        int fatorBalanceamento = balanceamento(no);
        if (fatorBalanceamento > 1) { 
            if (balanceamento(no.getFilhoDireito()) < 0) {
            
                no.setFilhoDireito(rotacaoDireita(no.getFilhoDireito()));
            }
            novaRaiz = rotacaoEsquerda(no);
        } else if (fatorBalanceamento < -1) { 
            if (balanceamento(no.getFilhoEsquerdo()) > 1) { 
                no.setFilhoEsquerdo(rotacaoEsquerda(no));
            }
            novaRaiz = rotacaoDireita(no);
        } else {
            novaRaiz = no;
        }
        return novaRaiz;
    }

    private NodoTriplo<T> rotacaoDireita(NodoTriplo<T> no) {
        NodoTriplo<T> filhoEsquerdo = no.getFilhoEsquerdo(); 
        NodoTriplo<T> filhoCentral = filhoEsquerdo.getFilhoDireito(); 
        filhoEsquerdo.setFilhoDireito(filhoEsquerdo); 
        no.setFilhoEsquerdo(filhoCentral);
        atualizaAltura(no);
        atualizaAltura(filhoEsquerdo);
        return filhoEsquerdo; 
    }

    private NodoTriplo<T> rotacaoEsquerda(NodoTriplo<T> no) {
        NodoTriplo<T> filhoDireito = no.getFilhoDireito(); 
        NodoTriplo<T> filhoCentral = filhoDireito.getFilhoEsquerdo(); 
        filhoDireito.setFilhoEsquerdo(no); 

        atualizaAltura(no);
        atualizaAltura(filhoDireito);

        return filhoDireito; 
    }

    @Override
    public NodoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void inserir(T dado) {
        if (dado == null) {
            throw new IllegalArgumentException("Dado nao pode ser nulo!");
        }
        NodoTriplo<T> novoNodo = new NodoTriplo<>(dado);

        if (raiz == null) { 
            raiz = novoNodo;
        } else {
            NodoTriplo<T> aux = raiz;
            while (true) {
                if (dado.compareTo(aux.getDado()) >= 0) { 
                    if (aux.getFilhoDireito() != null) { 
                        aux = aux.getFilhoDireito();
                    } else { 
                        aux.setFilhoDireito(novoNodo);
                        novoNodo.setGenitor(aux);

                        NodoTriplo<T> atual = novoNodo.getGenitor();
                        while (atual != null) { 
                            atualizaAltura(atual);
                            aplicarRotacao(atual);
                            atual = atual.getGenitor();
                        }
                        break;
                    }
                } else {
                    if (aux.getFilhoDireito() != null) {
                        aux = aux.getFilhoEsquerdo();
                    } else {
                        aux.setFilhoEsquerdo(novoNodo);
                        novoNodo.setGenitor(aux);

                        NodoTriplo<T> atual = novoNodo.getGenitor();
                        while (atual != null) {
                            atualizaAltura(atual);
                            aplicarRotacao(atual);
                            atual = atual.getGenitor();
                        }
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void apagar(T dado){
        NodoTriplo<T> aux = buscar(dado);
        if (aux == null)
            throw new Exception("Dado não existe!");
        if (aux.getFilhoEsquerdo() == null && aux.getFilhoDireito() == null) {
            apagarNoFolha(aux);
        } else if (aux.getFilhoEsquerdo() == null || aux.getFilhoDireito() == null) {
            apagarComUmFilho(aux);
        } else {
            apagarComDoisFilhos(aux);
        }

        NodoTriplo<T> atual = aux.getGenitor();
        while (atual != null) {
            atualizaAltura(atual);
            aplicarRotacao(atual);
            atual = atual.getGenitor();
        }

    }

    private void apagarNoFolha(NodoTriplo<T> no) {
        if (no == raiz) {
            raiz = null;
        } else {
            NodoTriplo<T> auxPai = no.getGenitor();
            if (auxPai.getFilhoEsquerdo() != null) {
                auxPai.setFilhoEsquerdo(null);
            } else {
                auxPai.setFilhoDireito(null);
            }
        }
    }

    private void apagarComUmFilho(NodoTriplo<T> no) {
        NodoTriplo<T> filho = (no.getFilhoEsquerdo() != null) ? no.getFilhoEsquerdo() : no.getFilhoDireito();

        if (no.getGenitor() == null) {
            raiz = filho;
            filho.setGenitor(null);
        } else {
            NodoTriplo<T> auxPai = no.getGenitor();
            if (auxPai.getFilhoEsquerdo() == no) {
                auxPai.setFilhoEsquerdo(filho);
            } else {
                auxPai.setFilhoDireito(filho);
            }
            filho.setGenitor(auxPai);
        }
    }

    private void apagarComDoisFilhos(NodoTriplo<T> no) {
        NodoTriplo<T> filhoCentral = no.getFilhoEsquerdo();
        while (filhoCentral.getFilhoDireito() != null) {
            filhoCentral = filhoCentral.getFilhoDireito();
        }

        no.setDado(filhoCentral.getDado());

        if (filhoCentral.getFilhoEsquerdo() != null) {
            apagarComUmFilho(filhoCentral);
        } else {
            apagarNoFolha(filhoCentral);
        }
    }

    @Override
    public boolean existe(T dado) {
        return existeRec(raiz, dado);
    }

    public boolean existeRec(NodoTriplo<T> no, T dado) {
        if (no == null) {
            return false;
        }
        if (no.getDado() == dado) {
            return true;
        }

        if (dado.compareTo(no.getDado()) >= 0) {
            return existeRec(no.getFilhoDireito(), dado);
        } else {
            return existeRec(no.getFilhoEsquerdo(), dado);
        }
    }

    @Override
    public void limpar() {
        raiz = null;
    }

    @Override
    public NodoTriplo<T> buscar(T dado) {
        return buscarRec(raiz, dado);
    }

    private NodoTriplo<T> buscarRec(NodoTriplo<T> no, T dado) {
        if (no == null) {
            return null;
        }
        if (no.getDado() == dado) {
            return no;
        }

        if (dado.compareTo(no.getDado()) >= 0) {
            return buscarRec(no.getFilhoDireito(), dado);
        } else {
            return buscarRec(no.getFilhoEsquerdo(), dado);
        }
    }

    public boolean estaBalanceada() {
        int fatorBalanceamento = balanceamento(raiz);
        return fatorBalanceamento == -1
                || fatorBalanceamento == 0
                || fatorBalanceamento == 1;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public String imprimirPreOrdem() {
        return imprimirPreOrdemRec(raiz);
    }

    private String imprimirPreOrdemRec(NodoTriplo<T> no) {
        if (no == null)
            return "";
        return no.getDado() + " " +
                imprimirPreOrdemRec(no.getFilhoEsquerdo()) + " " +
                imprimirPreOrdemRec(no.getFilhoDireito());
    }

    public String imprimirEmOrdem() {
        return imprimirEmOrdemRec(raiz);
    }

    private String imprimirEmOrdemRec(NodoTriplo<T> no) {
        if (no == null)
            return "";
        return imprimirPreOrdemRec(no.getFilhoEsquerdo()) + " " +
                no.getDado() +
                imprimirPreOrdemRec(no.getFilhoDireito());
    }

    public String imprimirPosOrdem() {
        return imprimirPosOrdemRec(raiz);
    }

    private String imprimirPosOrdemRec(NodoTriplo<T> no) {
        if (no == null)
            return "";
        return imprimirPreOrdemRec(no.getFilhoEsquerdo()) + " " +
                imprimirPreOrdemRec(no.getFilhoDireito()) + " " +
                no.getDado();
    }

    public int contarPreOrdem() {
        return contarPreOrdemRec(raiz);
    }

    private int contarPreOrdemRec(NodoTriplo<T> no) {
        if (no == null)
            return 0;
        return 1 +
                contarPreOrdemRec(no.getFilhoEsquerdo()) +
                contarPreOrdemRec(no.getFilhoDireito());
    }

    public int somarPreOrdem() {
        return somarPreOrdemRec(raiz);
    }

    private int somarPreOrdemRec(NodoTriplo<T> no) {
        if (no == null)
            return 0;
        return (Integer) no.getDado() +
                somarPreOrdemRec(no.getFilhoEsquerdo()) +
                somarPreOrdemRec(no.getFilhoDireito());
    }

    private boolean ehFolha(NodoTriplo<T> no) {
        return (no.getFilhoEsquerdo() == null) && (no.getFilhoDireito() == null);
    }

    public int contarFolhasPreOrdem() {
        return contarFolhasPreOrdemRec(raiz);
    }

    private int contarFolhasPreOrdemRec(NodoTriplo<T> no) {
        if (no == null)
            return 0;
        if (ehFolha(no))
            return 1;
        return contarFolhasPreOrdemRec(no.getFilhoEsquerdo()) +
                contarFolhasPreOrdemRec(no.getFilhoDireito());
    }
}
