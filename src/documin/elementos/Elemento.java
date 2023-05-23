package documin.elementos;

import java.util.Map;

public abstract class Elemento {
    protected int prioridade;
    protected String valor;
    protected Map<String, String> propriedades;

    public abstract String getVersaoCompleta();
    public abstract String getVersaoResumida();
}

