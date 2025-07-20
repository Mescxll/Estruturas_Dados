import java.util.NoSuchElementException;

public class ArvoreBinariaPesquisa<T> implements Arborivel<T> {
    private NodoTriplo<T> raiz;

    public ArvoreBinariaPesquisa() {
        this.raiz = null;
    }

    @Override
    public NodoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void inserir(T dado) {
        NodoTriplo<T> novoDado = new NodoTriplo(dado);
        NodoTriplo<T> aux = raiz;

        if (dado == null) {
            throw new IllegalArgumentException("Dado inválido");
        }
        if (raiz == null) {
            raiz = novoDado;
        } else {
            while (true) {
                if ((Integer) dado <= (Integer) aux.getDado()) {
                    if (aux.getFilhoEsquerdo() != null) {
                        aux = aux.getFilhoEsquerdo();
                    } else {
                        aux.setFilhoEsquerdo(novoDado);
                        novoDado.setGenitor(aux);
                        break;
                    }
                }
                if ((Integer) dado > (Integer) aux.getDado()) {
                    if (aux.getFilhoDireito() != null) {
                        aux = aux.getFilhoDireito();
                    } else {
                        aux.setFilhoDireito(novoDado);
                        novoDado.setGenitor(aux);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void apagar(T dado) {
        if (dado == null) {
            throw new IllegalArgumentException("Dado inválido");
        } else if (raiz == null) {
            throw new IllegalArgumentException("Árvore vazia");
        }

        if (existe(dado)) {
            NodoTriplo<T> nodo = buscar(dado);
            if (nodo.getFilhoDireito() == null && nodo.getFilhoEsquerdo() == null)
                apagarNoFolha(nodo);
            if (nodo.getFilhoDireito() == null && nodo.getFilhoEsquerdo() != null)
                apagarComUmFilho(nodo);
            if (nodo.getFilhoDireito() != null && nodo.getFilhoEsquerdo() == null)
                apagarComUmFilho(nodo);
            if (nodo.getFilhoDireito() != null && nodo.getFilhoEsquerdo() != null)
                apagarDoisFilhos(nodo);
        } else {
            throw new NoSuchElementException("Dado inexistente");
        }

    }

    public void apagarNoFilho(NodoTriplo<T> no) {
        NodoTriplo<T> auxPai = no.getGenitor();
        if (auxPai.getFilhoEsquerdo().getDado().compareTo(no.getDado()) == 0)
            auxPai.setFilhoEsquerdo(null);
        else
            auxPai.setFilhoDireito(null);
    }

    public void apagarComUmFilho(NodoTriplo<T> no) {
        NodoTriplo<T> auxPai = no.getGenitor();
        NodoTriplo<T> auxFilho;
        if (no.getFilhoEsquerdo() != null)
            auxFilho = no.getFilhoEsquerdo();
        else
            auxFilho = no.getFilhoDireito();

        auxFilho.setGenitor(auxPai);

        if (auxPai.getFilhoEsquerdo().getDado().compareTo(no.getDado()) == 0)
            auxPai.setFilhoEsquerdo(auxFilho);
        else
            auxPai.setFilhoDireito(auxFilho);
    }

    public void apagarComDoisFilhos(NodoTriplo<T> no) {
        NodoTriplo<T> aux = no.getFilhoEsquerdo();
        NodoTriplo<T> auxPai = no;
        while (aux.getFilhoDireito() != null) {
            auxPai = aux;
            aux = aux.getFilhoDireito();
        }
        no.setDado(aux.getDado());
        if (auxPai == no) {
            auxPai.setFilhoEsquerdo(aux.getFilhoEsquerdo());
            if (aux.getFilhoEsquerdo() != null)
                aux.getFilhoEsquerdo().setGenitor(auxPai);
        } else {
            auxPai.setFilhoDireito(aux.getFilhoEsquerdo());
            if (aux.getFilhoEsquerdo() != null)
                aux.getFilhoEsquerdo().setGenitor(auxPai);
        }
    }

    @Override
    public boolean existe(T dado) {
        if (raiz == null || dado == null)
            return false;
        NodoTriplo<T> aux = raiz;
        while (aux != null) {
            int cmp = dado.compareTo(aux.getDado());
            if (cmp == 0)
                return true;
            aux = (cmp < 0) ? aux.getFilhoEsquerdo() : aux.getFilhoDireito();
        }
        return false;
    }

    @Override
    public NodoTriplo<T> buscar(T dado) {
        if (raiz == null || dado == null)
            return null;
        NodoTriplo<T> aux = raiz;
        while (true) {
            if ((Integer) dado == (Integer) aux.getDado()) {
                return aux;
            } else {
                if ((Integer) dado < (Integer) aux.getDado()) {
                    if (aux.getFilhoEsquerdo() != null)
                        aux = aux.getFilhoEsquerdo();
                    else
                        return null;
                }
                if ((Integer) dado > (Integer) aux.getDado()) {
                    if (aux.getFilhoDireito() != null)
                        aux = aux.getFilhoDireito();
                    else
                        return null;
                }
            }
        }
    }

    public boolean existRec(NodoTriplo<T> subArvore, T dado) {
        if (subArvore == null)
            return false;
        if (Objects.equals(dado, subArvore.getDado()))
            return true;
        boolean aux = false;
        if (dado.compareTo(subArvore.getDado()) > 0) {
            if (subArvore.getFilhoDireito() != null) {
                aux = existeRec(subArvore.getFilhoDireito(), dado);
            }
        } else {
            if (subArvore.getFilhoEsquerdo() != null) {
                aux = existeRec(subArvore.getFilhoEsquerdo(), dado);
            }
        }
        return aux;
    }

    @Override
    public void limpar() {
        raiz = null;
    }

    public String imprimirPreOrdem(NodoTriplo<T> nodo) {
        if (nodo == null)
            return "";
        return nodo.getDado() + " " +
                imprimirPreOrdem(nodo.getEsquerdo()) + " " +
                imprimirPreOrdem(nodo.getDireito());
    }

    public String imprimirEmOrdemRec(NodoTriplo<T> nodo) {
        if (nodo == null)
            return "";
        return imprimirEmOrdemRec(nodo.getEsquerdo()) + " " +
                nodo.getDado() + " " + imprimirEmOrdemRec(nodo.getDireito());
    }

    public String imprimirPosOrdem(NodoTriplo<T> nodo) {
        if (nodo == null)
            return "";
        return imprimirEmOrdemRec(nodo.getEsquerdo()) + " " +
                imprimirEmOrdemRec(nodo.getDireito()) + " " + nodo.getDado();
    }

    private int contarPreOrdem(NodoTriplo<T> nodo) {
        if (nodo == null)
            return 0;
        return 1 + contarPreOrdem(nodo.getEsquerdo()) + contarPreOrdem(nodo.getDireito());
    }

    private int somarPreOrdem(NodoTriplo<T> nodo) {
        if (nodo == null)
            return 0;
        if (ehFolha(nodo))
            return 1;
        return -1; 
    }

    boolean ehFolha(NodoTriplo<T> nodo) {
        if ((nodo.getEsquerdo() == null) && (nodo.getDireito() == null))
            return true;
        return false;
    }
}
