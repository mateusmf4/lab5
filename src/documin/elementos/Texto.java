package documin.elementos;

/**
 * Um elemento básico de texto.
 */
public class Texto extends Elemento {
    /**
     * Cria o texto
     * @param prioridade Deve ser de 1 a 5 incluso.
     * @param valor Valor do elemento.
     */
    public Texto(int prioridade, String valor) {
        super(prioridade, valor);
    }

    @Override
    public String getVersaoCompleta() {
        return valor;
    }

    @Override
    public String getVersaoResumida() {
        return valor;
    }
}
