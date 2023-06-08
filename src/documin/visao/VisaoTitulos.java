package documin.visao;

import documin.Documento;

/**
 * Uma visão titulos mostra todos os elementos titulo de um documento,
 * de forma resumida.
 */
public class VisaoTitulos extends Visao {
    public VisaoTitulos(Documento documento) {
        super(documento);
    }

    @Override
    public String[] exibir() {
        return documento.versaoTitulosResumidos();
    }
}
