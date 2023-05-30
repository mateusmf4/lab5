package documin.elementos;

public abstract class Elemento {
    protected int prioridade;
    protected String valor;

    protected Elemento(int prioridade, String valor) {
        this.prioridade = prioridade;
        this.valor = valor;
    }

    public abstract String getVersaoCompleta();
    public abstract String getVersaoResumida();
}

