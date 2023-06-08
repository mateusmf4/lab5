package documin.elementos;

import documin.Documento;

/**
 * Representa um atalho a outro documento
 */
public class Atalho extends Elemento {
    private Documento documento;

    /**
     * Cria um atalho.
     * A prioridade é escolhida a partir da prioridade media do documento.
     * @param documento Documento a ser linkado. Não pode conter atalhos.
     */
    public Atalho(Documento documento) {
        super(documento.prioridadeMedia(), documento.getTitulo());
        this.documento = documento;
    }

    @Override
    public String getVersaoCompleta() {
        return String.join("\n", documento.versaoCompletaPrioritaria(4));
    }
    
    @Override
    public String getVersaoResumida() {
        return String.join("\n", documento.versaoResumidaPrioritaria(4));
    }

    public Documento getDocumentoReferenciado() {
        return documento;
    }
}
