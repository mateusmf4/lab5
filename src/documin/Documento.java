package documin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import documin.elementos.Atalho;
import documin.elementos.Elemento;
import documin.elementos.Titulo;

/**
 * Representa um Documento no sistema Documin,
 * tal documento tem um titulo e elementos, com tamanho maximo opcional
 */
public class Documento {
    private String titulo;
    private List<Elemento> elementos = new ArrayList<>();
    private int maxElementos = -1;
    private int quantAtalhos = 0;
    // em quantos atalhos é referenciado
    private int quantRefAtalho = 0;

    /**
     * Cria um documento sem limite de elementos.
     * @param titulo Titulo do documento
     */
    public Documento(String titulo) {
        this.titulo = titulo; 
    }

    /**
     * Cria um documento com limite de elementos.
     * @param titulo Titulo do documento
     * @param maxElementos Numero maximo de elementos no documento.
     */
    public Documento(String titulo, int maxElementos) {
        this(titulo);
        if (maxElementos <= 0)
            throw new IllegalArgumentException("maxElementos tem que ser maior que 0");
        this.maxElementos = maxElementos;
    }

    /**
     * Adiciona um elemento ao documento
     * @param elemento Elemento a ser adicionado
     * @return Indice do elemento no documento
     */
    public int adicionarElemento(Elemento elemento) {
        if (maxElementos != -1 && elementos.size() >= maxElementos) {
            throw new IllegalStateException("Número maximo de elementos excedido");
        }
        elementos.add(elemento);
        return elementos.size() - 1;
    }

    /**
     * Adiciona um atalho a outro documento
     * @param documentoRef Documento a ser referenciado no atalho
     * @return Indice do atalho adicionado
     */
    public int adicionarAtalho(Documento documentoRef) {
        if (this == documentoRef)
            throw new IllegalArgumentException("Documento atalho não pode ser sí mesmo");
        if (quantRefAtalho > 0)
            throw new IllegalArgumentException("Documento é um atalho e não pode adicionar atalhos");
        if (documentoRef.quantAtalhos > 0)
            throw new IllegalArgumentException("Documento referenciado não pode ter atalhos");
        quantAtalhos++;
        documentoRef.quantRefAtalho++;
        return adicionarElemento(new Atalho(documentoRef));
    }

    /**
     * Troca o elemento em uma posição com o elemento acima.
     * Se a posição for 0, não faz nada, pois é o elemento no topo.
     * @param posicao Indice do elemento.
     */
    public void moverElementoPraCima(int posicao) {
        if (posicao == 0) return;
        Collections.swap(elementos, posicao, posicao - 1);
    }

    /**
     * Troca o elemento em uma posição com o elemento abaixo.
     * Se a posição for o ultimo indice da lista de elementos, não faz nada.
     * @param posicao Indice do elemento.
     */
    public void moverElementoPraBaixo(int posicao) {
        if (posicao == elementos.size() - 1) return;
        Collections.swap(elementos, posicao, posicao + 1);
    }

    /**
     * A quantidade de elementos no documento.
     * @return A quantidade de elementos no documento.
     */
    public int contarElementos() {
        return elementos.size();
    }

    private Elemento pegarElemento(int posicao) {
        if (posicao < 0 || posicao >= elementos.size()) {
            throw new IndexOutOfBoundsException("Elemento não existe");
        }
        return elementos.get(posicao);
    }

    /**
     * Retorna a representação completa de um elemento.
     * @param elementoPosicao Indice do elemento.
     * @return A representação
     */
    public String pegarRepresentacaoCompleta(int elementoPosicao) {
        return pegarElemento(elementoPosicao).getVersaoCompleta(); 
    }

    /**
     * Retorna a representação resumida de um elemento.
     * @param elementoPosicao Indice do elemento.
     * @return A representação
     */
    public String pegarRepresentacaoResumida(int elementoPosicao) {
        return pegarElemento(elementoPosicao).getVersaoResumida();
    }

    /**
     * Remove um elemento do documento.
     * @param posicao Indice do elemento
     * @return true se o elemento foi removido, false se o indice for invalido
     */
    public boolean apagarElemento(int posicao) {
        if (posicao < 0 || posicao >= elementos.size()) return false;
        Elemento el = elementos.get(posicao);
        if (el instanceof Atalho) {
            Atalho atalho = (Atalho) el;
            Documento docRef = atalho.getDocumentoReferenciado();
            docRef.quantRefAtalho--;
            quantAtalhos--;
        }
        elementos.remove(posicao);
        return true;
    }

    /**
     * Retorna uma array com a representação completa de todos os elementos.
     * @return A array
     */
    public String[] exibir() {
        return versaoCompletaPrioritaria(0);
    }

    /**
     * Calcula a prioridade media de todos os elementos.
     * Se o documento não tem nenhum elemento, retorna 1.
     * @return A prioridade media
     */
    public int prioridadeMedia() {
        if (elementos.isEmpty()) return 1;
        int sum = 0;
        for (Elemento el : elementos) {
            sum += el.getPrioridade();
        }
        return sum / elementos.size();
    }

    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna uma array com a versão completa de todos os elementos
     * do documento com uma prioridade maior ou igual que _minPrioridade_
     * @param minPrioridade Prioridade minima.
     * @return A array
     */
    public String[] versaoCompletaPrioritaria(int minPrioridade) {
        ArrayList<String> result = new ArrayList<>();

        for (Elemento el : elementos) {
            if (el.getPrioridade() >= minPrioridade)
                result.add(el.getVersaoCompleta());
        }

        return result.toArray(new String[result.size()]);
    }

    /**
     * Retorna uma array com a versão resumida de todos os elementos
     * do documento com uma prioridade maior ou igual que _minPrioridade_
     * @param minPrioridade Prioridade minima.
     * @return A array
     */
    public String[] versaoResumidaPrioritaria(int minPrioridade) {
        ArrayList<String> result = new ArrayList<>();

        for (Elemento el : elementos) {
            if (el.getPrioridade() >= minPrioridade)
                result.add(el.getVersaoResumida());
        }

        return result.toArray(new String[result.size()]);
    }

    /**
     * Retorna uma array com a versão resumida de todos os titulos
     * do documento.
     * @return A array
     */
    public String[] versaoTitulosResumidos() {
        ArrayList<String> result = new ArrayList<>();

        for (Elemento el : elementos) {
            if (el instanceof Titulo)
                result.add(el.getVersaoResumida());
        }

        return result.toArray(new String[result.size()]);
    }
}
