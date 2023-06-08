package documin.visao;

import documin.Documento;

/**
 * Uma visão completa mostra todos os elementos de um documento
 * pela sua versão completa
 */
public class VisaoCompleta extends Visao {
    public VisaoCompleta(Documento documento) {
        super(documento);
    }

    @Override
    public String[] exibir() {
        return documento.versaoCompletaPrioritaria(0);
    }
}
