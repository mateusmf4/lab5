package documin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static documin.TestUtils.assertThrowsMsg;

public class DocumentoControllerTeste {
    private DocumentoController controller;

    @BeforeEach
    public void setup() {
        controller = new DocumentoController();
    }

    @Test
    public void testeCriarRemoverDocumento() {
        assertTrue(controller.criarDocumento("Vida Josefino"));
        // titulo já usado
        assertFalse(controller.criarDocumento("Vida Josefino"));

        assertEquals(0, controller.contarElementos("Vida Josefino"));

        assertTrue(controller.criarDocumento("Curta historia", 10));

        assertEquals(0, controller.contarElementos("Curta historia"));

        controller.removerDocumento("Vida Josefino");
        controller.removerDocumento("Curta historia");
        assertThrowsMsg(
            NoSuchElementException.class,
            () -> controller.removerDocumento("Curta historia"),
            "Documento não encontrado"
        );
        assertThrowsMsg(
            NoSuchElementException.class,
            () -> controller.removerDocumento("Wow"),
            "Documento não encontrado"
        );
    }

    @Test
    public void testeCriarDocumentoMaxElemento() {
        assertTrue(controller.criarDocumento("Breve", 3));

        assertEquals(0, controller.criarTexto("Breve", "Bom dia", 1));
        assertEquals(1, controller.criarTexto("Breve", "Boa tarde", 2));
        assertEquals(2, controller.criarTexto("Breve", "Boa noite", 3));
        
        assertThrowsMsg(IllegalStateException.class, () -> controller.criarTexto("Breve", "boa manhã", 1), "Número maximo de elementos excedido");
        
        assertTrue(controller.apagarElemento("Breve", 0));
        assertEquals(2, controller.criarTexto("Breve", "Ola", 3));
    }

    @Test
    public void testeExibirDocumento() {
        controller.criarDocumento("Anotações");

        assertEquals(0, controller.criarTitulo("Anotações", "Aula Calculo", 1, 1, true));
        assertEquals(1, controller.criarTexto("Anotações", "Na aula hj vi integrais", 1));
        assertEquals(2, controller.criarLista("Anotações", "(x^n)' = nx^n-1|sen'(x) = cos(x)", 1, "|", "*"));

        assertArrayEquals(new String[] {
            "1. Aula Calculo -- 1-AULACALCULO",
            "Na aula hj vi integrais",
            "* (x^n)' = nx^n-1\n* sen'(x) = cos(x)",
        }, controller.exibirDocumento("Anotações"));

        controller.criarTexto("Anotações", "Um assunto interessante", 1);
        controller.apagarElemento("Anotações", 1); // texto "na aula vi integrais"
        controller.moverParaCima("Anotações", 2);

        assertArrayEquals(new String[] {
            "1. Aula Calculo -- 1-AULACALCULO",
            "Um assunto interessante",
            "* (x^n)' = nx^n-1\n* sen'(x) = cos(x)",
        }, controller.exibirDocumento("Anotações"));
    }

    @Test
    public void testeVisoes() {
        controller.criarDocumento("Meu Doc");

        assertEquals(0, controller.criarTitulo("Meu Doc", "Um Titulo", 5, 1, true));
        assertEquals(1, controller.criarTexto("Meu Doc", "Wow incrivel", 3));
        assertEquals(2, controller.criarTitulo("Meu Doc", "Sub titulo", 4, 3, false));

        int visaoComp = controller.criarVisaoCompleta("Meu Doc");

        assertArrayEquals(new String[] {
            "1. Um Titulo -- 1-UMTITULO",
            "Wow incrivel",
            "3. Sub titulo",
        }, controller.exibirVisao(visaoComp));

        int visaoTitulo = controller.criarVisaoTitulo("Meu Doc");

        assertArrayEquals(new String[] {
            "1. Um Titulo",
            "3. Sub titulo",
        }, controller.exibirVisao(visaoTitulo));

        int visaoResumida = controller.criarVisaoResumida("Meu Doc");

        assertArrayEquals(new String[] {
            "1. Um Titulo",
            "Wow incrivel",
            "3. Sub titulo",
        }, controller.exibirVisao(visaoResumida));

        int visaoPrioritaria4 = controller.criarVisaoPrioritaria("Meu Doc", 4);

        assertArrayEquals(new String[] {
            "1. Um Titulo -- 1-UMTITULO",
            "3. Sub titulo",
        }, controller.exibirVisao(visaoPrioritaria4));

        int visaoPrioritaria5 = controller.criarVisaoPrioritaria("Meu Doc", 5);

        assertArrayEquals(new String[] {
            "1. Um Titulo -- 1-UMTITULO",
        }, controller.exibirVisao(visaoPrioritaria5));
    }

    @Test
    public void testeCriarAtalhos() {
        controller.criarDocumento("Vida Josefino");
        controller.criarDocumento("Jornada Josefino");
        controller.criarDocumento("Biografia Josefino");
        controller.criarDocumento("Meu doggy");

        controller.criarAtalho("Biografia Josefino", "Jornada Josefino");
        controller.criarAtalho("Vida Josefino", "Jornada Josefino");
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> controller.criarAtalho("Biografia Josefino", "Vida Josefino"),
            "Documento referenciado não pode ter atalhos"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> controller.criarAtalho("Biografia Josefino", "Biografia Josefino"),
            "Documento atalho não pode ser sí mesmo"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> controller.criarAtalho("Jornada Josefino", "Meu doggy"),
            "Documento é um atalho e não pode adicionar atalhos"
        );
    }
}
