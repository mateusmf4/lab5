package documin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import documin.elementos.Lista;
import documin.elementos.OrdemTermos;
import documin.elementos.Termos;
import documin.elementos.Texto;
import documin.elementos.Titulo;
import documin.visao.Visao;
import documin.visao.VisaoCompleta;
import documin.visao.VisaoPrioritaria;
import documin.visao.VisaoResumida;
import documin.visao.VisaoTitulos;

/**
 * Representa a classe principal do sistema documin,
 * guardando os documentos e as visões sobre os mesmos.
 */
public class DocumentoController {
    private Map<String, Documento> documentos = new HashMap<>();
    private List<Visao> visoes = new ArrayList<>();

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

    /**
     * Cria um documento com um titulo.
     * @param titulo Titulo do documento. Não pode ser vazio
     * @return false se um documento com o mesmo titulo já existe no controller, true se não
     */
    public boolean criarDocumento(String titulo) {
        verificarTitulo(titulo);
        if (documentos.containsKey(titulo)) return false;
        documentos.put(titulo, new Documento(titulo));
        return true;
    }

    /**
     * Cria um documento com um titulo e número máximo de elementos.
     * @param titulo Titulo do documento. Não pode ser vazio
     * @param maxElementos Numero maximo de elementos no documento.
     * @return false se um documento com o mesmo titulo já existe no controller, true se não
     */
    public boolean criarDocumento(String titulo, int maxElementos) {
        verificarTitulo(titulo);
        if (documentos.containsKey(titulo)) return false;
        documentos.put(titulo, new Documento(titulo, maxElementos));
        return true;
    }

    /**
     * Remove um documento do controller.
     * @param titulo Titulo do documento.
     */
    public void removerDocumento(String titulo) {       
        pegarDocumento(titulo);
        documentos.remove(titulo);
    }

    /**
     * @param titulo Titulo do documento.
     * @return A quantidade de elementos no documento.
     */
    public int contarElementos(String titulo) {
        return pegarDocumento(titulo).contarElementos();
    }

    /**
     * Retorna uma array com a representação completa de todos os elementos.
     * @param titulo Titulo do documento.
     * @return A array
     */
    public String[] exibirDocumento(String titulo) {
        return pegarDocumento(titulo).exibir();
    }

    /**
     * Cria um elemento de texto no documento.
     * @param tituloDoc Titulo do documento.
     * @param valor Valor do texto.
     * @param prioridade Prioridade do elemento.
     * @return O indice do elemento.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Texto(prioridade, valor));
    }

    /**
     * Cria um elemento de titulo no documento.
     * @param tituloDoc Titulo do documento.
     * @param valor Valor do titulo.
     * @param prioridade Prioridade do elemento.
     * @param nivel Nivel do titulo. Deve ser de 1 a 5 incluso.
     * @param linkavel Se o titulo é linkavel.
     * @return O indice do elemento.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Titulo(prioridade, valor, nivel, linkavel));
    }

    /**
     * Cria um elemento de lista no documento.
     * @param tituloDoc Titulo do documento.
     * @param valorLista Valor do elemento. Deve ser separado pelo _separador_ dado.
     * @param prioridade Prioridade do elemento.
     * @param separador Separador dos valores passados em _valor_
     * @param charLista Caractere utilizado para a representação completa.
     * @return O indice do elemento.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Lista(prioridade, valorLista, separador, charLista));
    }

    /**
     * Cria um elemento de termos no documento.
     * @param tituloDoc Titulo do documento.
     * @param valorTermos Valor do elemento. Deve ser separado pelo _separador_ dado.
     * @param prioridade Prioridade do elemento.
     * @param separador Separador dos valores passados em _valor_
     * @param ordem Especifica a ordem para ordernar os valores
     * @return O indice do elemento.
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return pegarDocumento(tituloDoc).adicionarElemento(new Termos(prioridade, valorTermos, separador, OrdemTermos.fromString(ordem)));
    }

    /**
     * Cria um elemento de atalho no documento.
     * @param tituloDoc Titulo do documento.
     * @param tituloDocReferenciado Titulo do documento a ser linkado. Tal documento não pode conter atalhos.
     * @return O indice do elemento.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return pegarDocumento(tituloDoc).adicionarAtalho(pegarDocumento(tituloDocReferenciado));
    }

    /**
     * Retorna a representação completa de um elemento de um documento.
     * @param tituloDoc Titulo do documento.
     * @param elementoPosicao Indice do elemento.
     * @return A representação.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return pegarDocumento(tituloDoc).pegarRepresentacaoCompleta(elementoPosicao);
    }

    /**
     * Retorna a representação resumida de um elemento de um documento.
     * @param tituloDoc Titulo do documento.
     * @param elementoPosicao Indice do elemento.
     * @return A representação.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return pegarDocumento(tituloDoc).pegarRepresentacaoResumida(elementoPosicao);
    }

    /**
     * Remove um elemento do documento.
     * @param tituloDoc Titulo do documento.
     * @param elementoPosicao Indice do elemento
     * @return true se o elemento foi removido, false se o indice for invalido
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return pegarDocumento(tituloDoc).apagarElemento(elementoPosicao);
    }

    /**
     * Troca o elemento em uma posição com o elemento acima.
     * Se a posição for 0, não faz nada, pois é o elemento no topo.
     * @param tituloDoc Titulo do documento.
     * @param elementoPosicao Indice do elemento.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        pegarDocumento(tituloDoc).moverElementoPraCima(elementoPosicao);
    }

    /**
     * Troca o elemento em uma posição com o elemento abaixo.
     * Se a posição for o ultimo indice da lista de elementos, não faz nada.
     * @param tituloDoc Titulo do documento.
     * @param elementoPosicao Indice do elemento.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        pegarDocumento(tituloDoc).moverElementoPraBaixo(elementoPosicao);
    }

    private int criarVisao(Visao visao) {
        visoes.add(visao);
        return visoes.size() - 1;
    }

    /**
     * Cria uma visão completa do documento.
     * @param tituloDoc Titulo do documento.
     * @return ID da visão criada.
     */
    public int criarVisaoCompleta(String tituloDoc) {
        return criarVisao(new VisaoCompleta(pegarDocumento(tituloDoc)));
    }

    /**
     * Cria uma visão resumida do documento.
     * @param tituloDoc Titulo do documento.
     * @return ID da visão criada.
     */
    public int criarVisaoResumida(String tituloDoc) {
        return criarVisao(new VisaoResumida(pegarDocumento(tituloDoc)));
    }

    /**
     * Cria uma visão prioritaria do documento.
     * @param tituloDoc Titulo do documento.
     * @param prioridade Prioridade mínima da visão.
     * @return ID da visão criada.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return criarVisao(new VisaoPrioritaria(pegarDocumento(tituloDoc), prioridade));
    }

    /**
     * Cria uma visão de titulos do documento.
     * @param tituloDoc Titulo do documento.
     * @return ID da visão criada.
     */
    public int criarVisaoTitulo(String tituloDoc) {
        return criarVisao(new VisaoTitulos(pegarDocumento(tituloDoc)));
    }
    
    /**
     * Exibe uma visão a partir do seu id.
     * @param visaoId ID da visão
     * @return Representação da visão em array.
     */
    public String[] exibirVisao(int visaoId) {
        if (visaoId < 0 || visaoId >= visoes.size())
            throw new IndexOutOfBoundsException("Visão não existe");
        return visoes.get(visaoId).exibir();
    }
}
