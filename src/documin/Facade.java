package documin;

public class Facade {
    private Documin controller = new Documin();

    public boolean criarDocumento(String titulo) {
        return controller.criarDocumento(titulo);
    }

    public boolean criarDocumento(String titulo, int maxElementos) {
        return controller.criarDocumento(titulo, maxElementos);
    }

    public void removerDocumento(String titulo) {
        controller.removerDocumento(titulo);
    }

    public int contarElementos(String titulo) {
        return controller.contarElementos(titulo);
    }

    public String[] exibirDocumento(String titulo) {
        return controller.exibirDocumento(titulo);
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return controller.criarTexto(tituloDoc, valor, prioridade);
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return controller.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return controller.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return controller.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return controller.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return controller.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return controller.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return controller.apagarElemento(tituloDoc, elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        controller.moverParaCima(tituloDoc, elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        controller.moverParaBaixo(tituloDoc, elementoPosicao);
    }

    public int criarVisaoCompleta(String tituloDoc) {
        return controller.criarVisaoCompleta(tituloDoc);
    }

    public int criarVisaoResumida(String tituloDoc) {
        return controller.criarVisaoResumida(tituloDoc);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return controller.criarVisaoPrioritaria(tituloDoc, prioridade);
    }

    public int criarVisaoTitulo(String tituloDoc) {
        return controller.criarVisaoTitulo(tituloDoc);
    }
    
    public String[] exibirVisao(int visaoId) {
        return controller.exibirVisao(visaoId);
    }

}
