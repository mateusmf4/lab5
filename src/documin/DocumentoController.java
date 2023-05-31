package documin;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import documin.elementos.Lista;
import documin.elementos.OrdemTermos;
import documin.elementos.Termos;
import documin.elementos.Texto;
import documin.elementos.Titulo;

public class DocumentoController {
    private Map<String, Documento> documentos = new HashMap<>();

    private void verificarTitulo(String titulo) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
    }

    private Documento pegarDocumento(String titulo) {
        verificarTitulo(titulo);
        if (!documentos.containsKey(titulo)) {
            throw new NoSuchElementException("Documento não encontrado");
        }
        return documentos.get(titulo);
    }

    public boolean criarDocumento(String titulo) {
        verificarTitulo(titulo);
        if (documentos.containsKey(titulo)) return false;
        documentos.put(titulo, new Documento(titulo));
        return true;
    }

    public boolean criarDocumento(String titulo, int maxElementos) {
        verificarTitulo(titulo);
        if (documentos.containsKey(titulo)) return false;
        documentos.put(titulo, new Documento(titulo, maxElementos));
        return true;
    }

    public void removerDocumento(String titulo) {       
        pegarDocumento(titulo);
        documentos.remove(titulo);
    }

    public int contarElementos(String titulo) {
        return pegarDocumento(titulo).contarElementos();
    }

    public String[] exibirDocumento(String titulo) {
        return pegarDocumento(titulo).exibir();
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Texto(prioridade, valor));
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Titulo(prioridade, valor, nivel, linkavel));
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Lista(prioridade, valorLista, separador, charLista));
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Termos(prioridade, valorTermos, separador, OrdemTermos.fromString(ordem)));
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return pegarDocumento(tituloDoc).adicionarAtalho(pegarDocumento(tituloDocReferenciado));
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return pegarDocumento(tituloDoc).pegarRepresentacaoCompleta(elementoPosicao);
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return pegarDocumento(tituloDoc).pegarRepresentacaoResumida(elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return pegarDocumento(tituloDoc).apagarElemento(elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        pegarDocumento(tituloDoc).moverElementoPraCima(elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        pegarDocumento(tituloDoc).moverElementoPraBaixo(elementoPosicao);
    }
}
