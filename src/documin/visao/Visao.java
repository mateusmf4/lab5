package documin.visao;

import documin.Documento;

public abstract class Visao {
    protected Documento documento;

    Visao(Documento documento) {
        this.documento = documento;
    }

    public abstract String[] exibir();
}
