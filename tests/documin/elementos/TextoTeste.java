package documin.elementos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TextoTeste {
    @Test
    public void testeSimples() {
        Elemento el = new Texto(2, "Bom dia");

        assertEquals("Bom dia", el.getVersaoCompleta());
        assertEquals("Bom dia", el.getVersaoResumida());

        Elemento el2 = new Texto(1, "AAA");

        assertEquals("AAA", el2.getVersaoCompleta());
        assertEquals("AAA", el2.getVersaoResumida());
    }
}
