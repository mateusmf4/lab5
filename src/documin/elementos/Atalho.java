package documin.elementos;

import documin.Documento;

public class Atalho extends Elemento {
    private Documento documento;

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

    public void remover() {
        documento.removerAtalho();
    }
}
