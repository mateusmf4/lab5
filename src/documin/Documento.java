package documin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import documin.elementos.Atalho;
import documin.elementos.Elemento;
import documin.elementos.Titulo;

public class Documento {
    private String titulo;
    private List<Elemento> elementos = new ArrayList<>();
    private int maxElementos = -1;
    private int quantAtalhos = 0;
    // em quantos atalhos é referenciado
    private int quantRefAtalho = 0;

    public Documento(String titulo) {
        this.titulo = titulo; 
    }

    public Documento(String titulo, int maxElementos) {
        this(titulo);
        this.maxElementos = maxElementos;
    }

    public int adicionarElemento(Elemento elemento) {
        if (maxElementos != -1 && elementos.size() >= maxElementos) {
            throw new IndexOutOfBoundsException("Número maximo de elementos excedido");
        }
        elementos.add(elemento);
        return elementos.size() - 1;
    }

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

    public void moverElementoPraCima(int posicao) {
        if (posicao == 0) return;
        Collections.swap(elementos, posicao, posicao - 1);
    }

    public void moverElementoPraBaixo(int posicao) {
        if (posicao == elementos.size() - 1) return;
        Collections.swap(elementos, posicao, posicao + 1);
    }

    public int contarElementos() {
        return elementos.size();
    }

    private Elemento pegarElemento(int posicao) {
        if (posicao < 0 || posicao >= elementos.size()) {
            throw new IndexOutOfBoundsException("Elemento não existe");
        }
        return elementos.get(posicao);
    }

    public String pegarRepresentacaoCompleta(int elementoPosicao) {
        return pegarElemento(elementoPosicao).getVersaoCompleta(); 
    }

    public String pegarRepresentacaoResumida(int elementoPosicao) {
        return pegarElemento(elementoPosicao).getVersaoResumida();
    }

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

    public String[] exibir() {
        return versaoCompletaPrioritaria(0);
    }

    public int prioridadeMedia() {
        if (elementos.isEmpty()) return 0;
        int sum = 0;
        for (Elemento el : elementos) {
            sum += el.getPrioridade();
        }
        return sum / elementos.size();
    }

    public String getTitulo() {
        return titulo;
    }

    public String[] versaoCompletaPrioritaria(int minPrioridade) {
        ArrayList<String> result = new ArrayList<>();

        for (Elemento el : elementos) {
            if (el.getPrioridade() >= minPrioridade)
                result.add(el.getVersaoCompleta());
        }

        return Utils.listToArray(result);
    }

    public String[] versaoResumidaPrioritaria(int minPrioridade) {
        ArrayList<String> result = new ArrayList<>();

        for (Elemento el : elementos) {
            if (el.getPrioridade() >= minPrioridade)
                result.add(el.getVersaoResumida());
        }

        return Utils.listToArray(result);
    }

    public String[] versaoTitulosResumidos() {
        ArrayList<String> result = new ArrayList<>();

        for (Elemento el : elementos) {
            if (el instanceof Titulo)
                result.add(el.getVersaoResumida());
        }

        return Utils.listToArray(result);
    }
}
