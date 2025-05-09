package Utils;

public class Noh {
    private Object info;
    private Noh ant;
    private Noh prox;

    public Noh(Object info) {
        this.info = info;
        this.ant = null;
        this.prox = null;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Noh getProx() {
        return prox;
    }

    public void setProx(Noh n) {
        this.prox = n;
    }

    public Noh getAnt() {
        return ant;
    }

    public void setAnt(Noh n) {
        this.ant = n;
    }
}