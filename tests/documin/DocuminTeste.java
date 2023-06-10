package documin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static documin.TestUtils.assertThrowsMsg;

public class DocuminTeste {
    private Documin sistema;

    @BeforeEach
    public void setup() {
        sistema = new Documin();
    }

    @Test
    public void testeCriarRemoverDocumento() {
        assertTrue(sistema.criarDocumento("Vida Josefino"));
        // titulo já usado
        assertFalse(sistema.criarDocumento("Vida Josefino"));

        assertEquals(0, sistema.contarElementos("Vida Josefino"));

        assertTrue(sistema.criarDocumento("Curta historia", 10));

        assertEquals(0, sistema.contarElementos("Curta historia"));

        sistema.removerDocumento("Vida Josefino");
        sistema.removerDocumento("Curta historia");
        assertThrowsMsg(
            NoSuchElementException.class,
            () -> sistema.removerDocumento("Curta historia"),
            "Documento não encontrado"
        );
        assertThrowsMsg(
            NoSuchElementException.class,
            () -> sistema.removerDocumento("Wow"),
            "Documento não encontrado"
        );
    }

    @Test
    public void testeCriarDocumentoMaxElemento() {
        assertTrue(sistema.criarDocumento("Breve", 3));

        assertEquals(0, sistema.criarTexto("Breve", "Bom dia", 1));
        assertEquals(1, sistema.criarTexto("Breve", "Boa tarde", 2));
        assertEquals(2, sistema.criarTexto("Breve", "Boa noite", 3));
        
        assertThrowsMsg(IllegalStateException.class, () -> sistema.criarTexto("Breve", "boa manhã", 1), "Número maximo de elementos excedido");
        
        assertTrue(sistema.apagarElemento("Breve", 0));
        assertEquals(2, sistema.criarTexto("Breve", "Ola", 3));
    }

    @Test
    public void testeExibirDocumento() {
        sistema.criarDocumento("Anotações");

        assertEquals(0, sistema.criarTitulo("Anotações", "Aula Calculo", 1, 1, true));
        assertEquals(1, sistema.criarTexto("Anotações", "Na aula hj vi integrais", 1));
        assertEquals(2, sistema.criarLista("Anotações", "(x^n)' = nx^n-1|sen'(x) = cos(x)", 1, "|", "*"));

        assertArrayEquals(new String[] {
            "1. Aula Calculo -- 1-AULACALCULO",
            "Na aula hj vi integrais",
            "* (x^n)' = nx^n-1\n* sen'(x) = cos(x)",
        }, sistema.exibirDocumento("Anotações"));

        sistema.criarTexto("Anotações", "Um assunto interessante", 1);
        sistema.apagarElemento("Anotações", 1); // texto "na aula vi integrais"
        sistema.moverParaCima("Anotações", 2);

        assertArrayEquals(new String[] {
            "1. Aula Calculo -- 1-AULACALCULO",
            "Um assunto interessante",
            "* (x^n)' = nx^n-1\n* sen'(x) = cos(x)",
        }, sistema.exibirDocumento("Anotações"));
    }

    @Test
    public void testeVisoes() {
        sistema.criarDocumento("Meu Doc");

        assertEquals(0, sistema.criarTitulo("Meu Doc", "Um Titulo", 5, 1, true));
        assertEquals(1, sistema.criarTexto("Meu Doc", "Wow incrivel", 3));
        assertEquals(2, sistema.criarTitulo("Meu Doc", "Sub titulo", 4, 3, false));

        int visaoComp = sistema.criarVisaoCompleta("Meu Doc");

        assertArrayEquals(new String[] {
            "1. Um Titulo -- 1-UMTITULO",
            "Wow incrivel",
            "3. Sub titulo",
        }, sistema.exibirVisao(visaoComp));

        int visaoTitulo = sistema.criarVisaoTitulo("Meu Doc");

        assertArrayEquals(new String[] {
            "1. Um Titulo",
            "3. Sub titulo",
        }, sistema.exibirVisao(visaoTitulo));

        int visaoResumida = sistema.criarVisaoResumida("Meu Doc");

        assertArrayEquals(new String[] {
            "1. Um Titulo",
            "Wow incrivel",
            "3. Sub titulo",
        }, sistema.exibirVisao(visaoResumida));

        int visaoPrioritaria4 = sistema.criarVisaoPrioritaria("Meu Doc", 4);

        assertArrayEquals(new String[] {
            "1. Um Titulo -- 1-UMTITULO",
            "3. Sub titulo",
        }, sistema.exibirVisao(visaoPrioritaria4));

        int visaoPrioritaria5 = sistema.criarVisaoPrioritaria("Meu Doc", 5);

        assertArrayEquals(new String[] {
            "1. Um Titulo -- 1-UMTITULO",
        }, sistema.exibirVisao(visaoPrioritaria5));
    }

    @Test
    public void testeCriarAtalhos() {
        sistema.criarDocumento("Vida Josefino");
        sistema.criarDocumento("Jornada Josefino");
        sistema.criarDocumento("Biografia Josefino");
        sistema.criarDocumento("Meu doggy");

        sistema.criarAtalho("Biografia Josefino", "Jornada Josefino");
        sistema.criarAtalho("Vida Josefino", "Jornada Josefino");
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarAtalho("Biografia Josefino", "Vida Josefino"),
            "Documento referenciado não pode ter atalhos"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarAtalho("Biografia Josefino", "Biografia Josefino"),
            "Documento atalho não pode ser sí mesmo"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarAtalho("Jornada Josefino", "Meu doggy"),
            "Documento é um atalho e não pode adicionar atalhos"
        );
    }

    @Test
    public void testeTituloInvalido() {
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarDocumento("   "),
            "Título não pode ser vazio"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarDocumento(""),
            "Título não pode ser vazio"
        );
        assertThrowsMsg(
            NoSuchElementException.class,
            () -> sistema.exibirDocumento("Josefino"),
            "Documento não encontrado"
        );
        sistema.criarDocumento("Historia");
        assertThrowsMsg(
            NoSuchElementException.class,
            () -> sistema.criarAtalho("Historia", "Josefino"),
            "Documento não encontrado"
        );
    }
    
    @Test
    public void testeElementosInvalidos() {
        sistema.criarDocumento("ola");

        sistema.criarTitulo("ola", "bom dia", 1, 1, false);
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarTexto("ola", "bom dia", 0),
            "Prioridade deve ser de 1 a 5 incluso"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarTexto("ola", "bom dia", 6),
            "Prioridade deve ser de 1 a 5 incluso"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarTitulo("ola", "bom dia", 1, 0, false),
            "Nível deve ser de 1 a 5 incluso"
        );
        assertThrowsMsg(
            IllegalArgumentException.class,
            () -> sistema.criarTitulo("ola", "bom dia", 1, 6, false),
            "Nível deve ser de 1 a 5 incluso"
        );

        assertThrowsMsg(
            IndexOutOfBoundsException.class,
            () -> sistema.pegarRepresentacaoResumida("ola", 1),
            "Elemento não existe"
        );
        assertThrowsMsg(
            IndexOutOfBoundsException.class,
            () -> sistema.pegarRepresentacaoResumida("ola", -1),
            "Elemento não existe"
        );
    }
}
