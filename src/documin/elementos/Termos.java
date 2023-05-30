package documin.elementos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Termos extends Elemento {
    private String separador;
    private String[] termos;

    Termos(int prioridade, String valor, String separador, OrdemTermos ordem) {
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
