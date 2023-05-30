package documin.elementos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ListaTeste {
    @Test
    public void testeSimples() {
        Elemento el = new Lista(2, "Exemplo | de uma lista | de 3 termos", "|", "-");

        assertEquals("- Exemplo\n- de uma lista\n- de 3 termos", el.getVersaoCompleta());
        assertEquals("Exemplo | de uma lista | de 3 termos", el.getVersaoResumida());
    }
}
