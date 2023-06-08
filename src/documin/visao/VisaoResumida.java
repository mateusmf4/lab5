package documin.visao;

import documin.Documento;

/**
 * Uma visão resumida mostra todos os elementos de um documento
 * em sua versão resumida.
 */
public class VisaoResumida extends Visao {
    public VisaoResumida(Documento documento) {
        super(documento);
    }

    @Override
    public String[] exibir() {
        return documento.versaoResumidaPrioritaria(0);
    }
}
