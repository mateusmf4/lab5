package documin.elementos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * Representa uma lista de termos, que podem ser ordenados
 * de forma alfabetica ou por tamanho
 */
public class Termos extends Elemento {
    private String separador;
    private String[] termos;

    /**
     * Cria os termos
     * @param prioridade Deve ser de 1 a 5 incluso.
     * @param valor Valor do elemento. Deve ser separado pelo _separador_ dado.
     * @param separador Separador dos valores passados em _valor_
     * @param ordem Especifica a ordem para ordernar os valores
     */
    public Termos(int prioridade, String valor, String separador, OrdemTermos ordem) {
        super(prioridade, valor);
        this.separador = separador;

        termos = valor.split(Pattern.quote(separador));
        for (int i = 0; i < termos.length; ++i) {
            termos[i] = termos[i].trim();
        }

        if (ordem == OrdemTermos.ALFABETICA) {
            Arrays.sort(termos, String::compareToIgnoreCase);
        } else if (ordem == OrdemTermos.TAMANHO) {
            Arrays.sort(termos, Comparator.comparingInt(String::length).reversed());
        }
    }

    @Override
    public String getVersaoCompleta() {
        return String.format("Total termos: %d\n- %s", termos.length, String.join(", ", termos));
    }

    @Override
    public String getVersaoResumida() {
        return String.join(" " + separador + " ", termos);
    }
}
