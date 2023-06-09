package documin.elementos;

import java.util.regex.Pattern;

/**
 * Representa uma lista de valores, separadas por um caractere
 */
public class Lista extends Elemento {
    private String separador;
    private String caractere;
    private String[] palavras;

    /**
     * Cria uma lista
     * @param prioridade Deve ser de 1 a 5 incluso.
     * @param valor Valor do elemento. Deve ser separado pelo _separador_ dado.
     * @param separador Separador dos valores passados em _valor_
     * @param caractere Caractere utilizado para a representação completa.
     */
    public Lista(int prioridade, String valor, String separador, String caractere) {
        super(prioridade, valor);
        this.separador = separador;
        this.caractere = caractere;

        this.addPropriedade("Separador", separador);
        this.addPropriedade("Caractere de Lista", caractere);
        
        palavras = valor.split(Pattern.quote(separador));
        for (int i = 0; i < palavras.length; ++i) {
            palavras[i] = palavras[i].trim();
        }
    }

    @Override
    public String getVersaoCompleta() {
        String resultado = "";
        for (String palavra : palavras) {
            resultado += caractere + " " + palavra + "\n";
        }
        return resultado.trim();
    }

    @Override
    public String getVersaoResumida() {
        return String.join(" " + separador + " ", palavras);
    }
}
