package documin;

public class Facade {
    public Facade() {

    }

    public boolean criarDocumento(String titulo) {
        return false;
    }

    public boolean criarDocumento(String titulo, int maxElementos) {
        return false;
    }

    public void removerDocumento(String titulo) {

    }

    public int contarElementos(String titulo) {
        return 0;
    }

    public String[] exibirDocumento(String titulo) {
        return null;
    }

    int criarTexto(String tituloDoc, String valor, int prioridade) {
        return 0;
    }

    int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return 0;
    }

    int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return 0;
    }

    int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return 0;
    }

    String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return null;
    }

    String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return null;
    }

    boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return false;
    }

    void moverParaCima(String tituloDoc, int elementoPosicao) {

    }

    void moverParaBaixo(String tituloDoc, int elementoPosicao) {

    }
}
