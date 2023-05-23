package documin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import documin.elementos.Elemento;

public class Documento {
    private String titulo;
    private List<Elemento> elementos = new ArrayList<>();
    private int maxElementos = -1;

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

    public void moverElementoPraCima(int posicao) {
        if (posicao == 0) return;
        Collections.swap(elementos, posicao, posicao - 1);
    }

    public void moverElementoPraBaixo(int posicao) {
        if (posicao == elementos.size() - 1) return;
        Collections.swap(elementos, posicao, posicao + 1);
    }

    public void removerElemento(int posicao) {

    }
}
