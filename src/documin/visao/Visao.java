package documin.visao;

import documin.Documento;

/*
 * Representa uma visão de um documento.
 */
public abstract class Visao {
    protected Documento documento;

    Visao(Documento documento) {
        this.documento = documento;
    }

    /**
     * Retorna uma array de strings a partir dos elementos do documento.
     * @return A array.
     */
    public abstract String[] exibir();
}
