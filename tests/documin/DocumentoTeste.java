package documin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import static documin.Utils.assertThrowsMsg;

public class DocumentoTeste {
    @Test
    public void testarDocumentoAtalho() {
        Documento d1 = new Documento("Vida Josefino");
        Documento d2 = new Documento("Jornada Josefino");
        Documento d3 = new Documento("Morte");
        Documento d4 = new Documento("Ressureição");

        assertEquals(0, d1.adicionarAtalho(d2));
        assertThrowsMsg(IllegalArgumentException.class, () -> d1.adicionarAtalho(d2), "Documento já tem atalho");
        assertThrowsMsg(IllegalArgumentException.class, () -> d1.adicionarAtalho(d3), "Documento já tem atalho");
        assertThrowsMsg(IllegalArgumentException.class, () -> d3.adicionarAtalho(d2), "Documento já é referenciado");
        // essa msg não é tecnicamente correta
        assertThrowsMsg(IllegalArgumentException.class, () -> d3.adicionarAtalho(d1), "Documento já é referenciado");
        assertThrowsMsg(IllegalArgumentException.class, () -> d3.adicionarAtalho(d3), "Documento atalho não pode ser sí mesmo");
        assertEquals(0, d4.adicionarAtalho(d3));
    }
}
