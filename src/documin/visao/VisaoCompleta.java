package documin.visao;

import documin.Documento;

public class VisaoCompleta extends Visao {
    public VisaoCompleta(Documento documento) {
        super(documento);
    }

    @Override
    public String[] exibir() {
        return documento.versaoCompletaPrioritaria(0);
    }
}
