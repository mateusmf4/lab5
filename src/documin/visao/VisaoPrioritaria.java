package documin.visao;

import documin.Documento;

/**
 * Uma visão prioritaria mostra todos os elementos de um documento
 * com uma prioridade maior ou igual do que desejada. Os elementos
 * são mostrados de forma completa.
 */
public class VisaoPrioritaria extends Visao {
    private int prioridade;

    public VisaoPrioritaria(Documento documento, int prioridade) {
        super(documento);
        this.prioridade = prioridade;
    }

    @Override
    public String[] exibir() {
        return documento.versaoCompletaPrioritaria(prioridade);
    }
}
