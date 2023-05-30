package documin.elementos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TermosTeste {
    @Test
    public void testeOrdemAlfabetica() {
        Elemento el = new Termos(2, "Teste / termos / Aleatórios", "/", OrdemTermos.ALFABETICA);

        assertEquals("Total termos: 3\n- Aleatórios, termos, Teste", el.getVersaoCompleta());
        assertEquals("Aleatórios / termos / Teste", el.getVersaoResumida());
    }

    @Test
    public void testeOrdemNenhum() {
        Elemento el = new Termos(2, "Teste ! termos ! Aleatórios", "!", OrdemTermos.NENHUM);

        assertEquals("Total termos: 3\n- Teste, termos, Aleatórios", el.getVersaoCompleta());
        assertEquals("Teste ! termos ! Aleatórios", el.getVersaoResumida());
    }

    @Test
    public void testeOrdemTamanho() {
        Elemento el = new Termos(2, "Testando :D termos :D Aleatórios", ":D", OrdemTermos.TAMANHO);

        assertEquals("Total termos: 3\n- Aleatórios, Testando, termos", el.getVersaoCompleta());
        assertEquals("Aleatórios :D Testando :D termos", el.getVersaoResumida());

        Elemento el2 = new Termos(2, "Josefino | Josefina | AlgumaCoisa", "|", OrdemTermos.TAMANHO);

        assertEquals("Total termos: 3\n- AlgumaCoisa, Josefino, Josefina", el2.getVersaoCompleta());
        assertEquals("AlgumaCoisa | Josefino | Josefina", el2.getVersaoResumida());
    }
}
