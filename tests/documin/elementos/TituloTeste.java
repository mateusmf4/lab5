package documin.elementos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TituloTeste {
    @Test
    public void testeLinkavel() {
        Elemento el = new Titulo(2, "Documentos Texto", 1, true);

        assertEquals("1. Documentos Texto -- 1-DOCUMENTOSTEXTO", el.getVersaoCompleta());
        assertEquals("1. Documentos Texto", el.getVersaoResumida());
    }

    @Test
    public void testeNaoLinkavel() {
        Elemento el = new Titulo(3, "Elementos simples", 3, false);

        assertEquals("3. Elementos simples", el.getVersaoCompleta());
        assertEquals("3. Elementos simples", el.getVersaoResumida());
    }
}
