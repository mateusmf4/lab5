package documin.elementos;

public class Titulo extends Elemento {
    private int nivel;
    private boolean linkavel;

    public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
        super(prioridade, valor);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    @Override
    public String getVersaoCompleta() {
        if (linkavel) {
            return this.getVersaoResumida() + " -- " + this.gerarLink();
        } else {
            return this.getVersaoResumida();
        }
    }

    @Override
    public String getVersaoResumida() {
        return String.format("%d. %s", nivel, valor);
    }

    String gerarLink() {
        return String.format("%d-%s", nivel, valor.toUpperCase().replace(" ", ""));
    }
}
