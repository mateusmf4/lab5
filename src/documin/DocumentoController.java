package documin;

import java.util.HashMap;
import java.util.Map;

public class DocumentoController {
    private Map<String, Documento> documentos = new HashMap<>();

    public boolean criarDocumento(String titulo) {
        documentos.put(titulo, new Documento(titulo));
        return true;
    }

    public boolean criarDocumento(String titulo, int maxElementos) {
        documentos.put(titulo, new Documento(titulo, maxElementos));
        return true;
    }

    public void removerDocumento(String titulo) {
        documentos.remove(titulo);
    }

    public int contarElementos(String titulo) {
        return documentos.get(titulo).contarElementos();
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

    String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
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
