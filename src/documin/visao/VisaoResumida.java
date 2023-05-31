package documin.visao;

import documin.Documento;

public class VisaoResumida extends Visao {
    public VisaoResumida(Documento documento) {
        super(documento);
    }

    @Override
    public String[] exibir() {
        return documento.versaoResumidaPrioritaria(0);
    }
}
