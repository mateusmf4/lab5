package documin.elementos;

public abstract class Elemento {
    protected int prioridade;
    protected String valor;

    protected Elemento(int prioridade, String valor) {
        if (prioridade < 1 || prioridade > 5) {
            throw new IllegalArgumentException("Prioridade deve ser de 1 a 5 incluso");
        }
        this.prioridade = prioridade;
        this.valor = valor;
    }

    public abstract String getVersaoCompleta();
    public abstract String getVersaoResumida();

    public int getPrioridade() {
        return prioridade;
    }
}

