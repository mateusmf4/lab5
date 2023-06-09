package documin;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import static documin.TestUtils.assertThrowsMsg;

public class DocumentoTeste {
    @Test
    public void testarDocumentoAtalho() {
        Documento d1 = new Documento("Vida Josefino");
        Documento d2 = new Documento("Jornada Josefino");
        Documento d3 = new Documento("Morte");
        Documento d4 = new Documento("Ressureição");

        assertEquals(0, d1.adicionarAtalho(d2));
        assertThrowsMsg(IllegalArgumentException.class, () -> d3.adicionarAtalho(d1), "Documento referenciado não pode ter atalhos");
        
        assertEquals(0, d3.adicionarAtalho(d2));
        assertThrowsMsg(IllegalArgumentException.class, () -> d2.adicionarAtalho(d4), "Documento é um atalho e não pode adicionar atalhos");
        
        assertThrowsMsg(IllegalArgumentException.class, () -> d3.adicionarAtalho(d3), "Documento atalho não pode ser sí mesmo");
        assertEquals(0, d4.adicionarAtalho(d2));
        // não fala nada sobre ter o mesmo atalho varias vezes!
        assertEquals(1, d4.adicionarAtalho(d2));

        assertTrue(d1.apagarElemento(0));

        // como removemos os atalhos de d1, então isso deve funcionar
        assertEquals(2, d4.adicionarAtalho(d1));
        assertTrue(d4.apagarElemento(2));

        assertTrue(d3.apagarElemento(0));
        // d3 não tem elementos, então deve retornar false
        assertFalse(d3.apagarElemento(0));
        
        // d2 é atalho duas vezes em d4
        assertThrowsMsg(IllegalArgumentException.class, () -> d2.adicionarAtalho(d1), "Documento é um atalho e não pode adicionar atalhos");
        assertTrue(d4.apagarElemento(0));
        // d2 ainda é atalho em d4
        assertThrowsMsg(IllegalArgumentException.class, () -> d2.adicionarAtalho(d1), "Documento é um atalho e não pode adicionar atalhos");
        assertTrue(d4.apagarElemento(0));
        // agora deve funcionar
        assertEquals(0, d2.adicionarAtalho(d1));
    }
}
