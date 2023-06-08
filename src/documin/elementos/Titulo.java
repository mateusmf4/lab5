package documin.elementos;

/**
 * Representa um titulo, que pode ter varios niveis
 */
public class Titulo extends Elemento {
    private int nivel;
    private boolean linkavel;

    /**
     * Cria o titulo
     * @param prioridade Deve ser de 1 a 5 incluso.
     * @param valor Valor do elemento.
     * @param nivel Nivel do titulo. Deve ser de 1 a 5 incluso.
     * @param linkavel Se o titulo é linkavel.
     */
    public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
        super(prioridade, valor);
        if (nivel < 1 || nivel > 5) {
            throw new IllegalArgumentException("Nivel deve ser de 1 a 5 incluso");
        }
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
