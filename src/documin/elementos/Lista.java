package documin.elementos;

import java.util.regex.Pattern;

public class Lista extends Elemento {
    private String separador;
    private String caractere;
    private String[] palavras;

    public Lista(int prioridade, String valor, String separador, String caractere) {
        super(prioridade, valor);
        this.separador = separador;
        this.caractere = caractere;
        
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
