package documin;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

        assertTrue(d1.apagarElemento(0));
        // d3 não tem elementos, então deve retornar false
        assertFalse(d3.apagarElemento(0));
        assertTrue(d4.apagarElemento(0));
        // como removemos os atalhos de d1 e d4, então isso deve funcionar
        assertEquals(0, d1.adicionarAtalho(d4));
        assertThrowsMsg(IllegalArgumentException.class, () -> d1.adicionarAtalho(d2), "Documento já tem atalho");
        assertThrowsMsg(IllegalArgumentException.class, () -> d3.adicionarAtalho(d4), "Documento já é referenciado");

    }
}
