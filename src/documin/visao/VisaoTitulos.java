package documin.visao;

import documin.Documento;

public class VisaoTitulos extends Visao {
    public VisaoTitulos(Documento documento) {
        super(documento);
    }

    @Override
    public String[] exibir() {
        return documento.versaoTitulosResumidos();
    }
}
