
public class LDE{
    private Noh inicio;
    private Noh ultimo;

    public LDE() {
        this.inicio = null;
    }

    public void insereInicio(Object info) {
        Noh novo = new Noh(info);
        if (inicio == null) {
            inicio = novo;
            ultimo = novo;
        }else {
            novo.setProx(inicio);
            inicio.setAnt(novo);
            inicio = novo;
        }
    }

    public void insereFim(Object info) {
        Noh novo = new Noh(info);
        if (ultimo == null) {
            inicio = novo;
            ultimo = novo;
        }else {
            novo.setAnt(ultimo);
            ultimo.setProx(novo);
            ultimo = novo;
        }
    }

    public boolean estahVazia(){
        Noh novo = inicio;
        if (novo != null) {
            return false;
        }
        return true;
    }

    private Noh busca(Object info) {
        Noh p = inicio;
        while (p != null && !p.getInfo().equals(info)) {
            p = p.getProx();
        }
        return p;
    }

    public boolean remove(Object info) {
        Noh p = busca(info);
        if (p==null)
            return false;
        if (p == inicio){
            inicio = p.getProx();
            if (inicio != null) inicio.setAnt(null);
            else ultimo = null;
        } else if (p.getProx() == null){
            p.getAnt().setProx(null);
            ultimo = p.getAnt();
        } else {
            p.getAnt().setProx(p.getProx());
            p.getProx().setAnt(p.getAnt());
        }
        return true;
    }

    public int tamanho(){
        int tamanho = 0;
        Noh novo = inicio;
        while (novo != null) {
            tamanho++;
            novo = novo.getProx();
        }
        return tamanho;
    }

    public void imprimeLista(){
        Noh novo = inicio;
        while (novo != null) {
            System.out.println(novo.getInfo());
            novo = novo.getProx();
        }
    }

    public void imprimeReverso() {
        Noh p = ultimo;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnt();
        }
    }
}
