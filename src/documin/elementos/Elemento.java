package documin.elementos;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um elemento qualquer do documento.
 */
public abstract class Elemento {
    protected int prioridade;
    protected String valor;
    private Map<String, String> propriedades = new HashMap<>();

    protected Elemento(int prioridade, String valor) {
        if (prioridade < 1 || prioridade > 5) {
            throw new IllegalArgumentException("Prioridade deve ser de 1 a 5 incluso");
        }
        this.prioridade = prioridade;
        this.valor = valor;
    }

    protected void addPropriedade(String key, Object valor) {
        propriedades.put(key, valor.toString());
    }

    /**
     * Retorna a versão completa do elemento, com mais detalhes.
     * @return Uma string.
     */
    public abstract String getVersaoCompleta();
    /**
     * Retorna a versão resumida do elemento, mais curta.
     * @return Uma string.
     */
    public abstract String getVersaoResumida();

    public int getPrioridade() {
        return prioridade;
    }
}

