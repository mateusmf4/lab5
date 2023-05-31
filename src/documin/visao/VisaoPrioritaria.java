package documin.visao;

import documin.Documento;

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
