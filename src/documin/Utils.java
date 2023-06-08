package documin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.function.Executable;

/**
 * Metodos de utilidade.
 */
public class Utils {
    /**
     * Converte um ArrayList<String> para String[]
     * @param arr Um ArrayList
     * @return Um array
     */
    public static String[] listToArray(ArrayList<String> arr) {
        return arr.toArray(new String[arr.size()]);
    }

    /**
     * assertThrows e assertEquals(exc.getMessage()), em um unico metodo
     */
    public static <T extends Throwable> void assertThrowsMsg(Class<T> expected, Executable executable, String msg) {
        assertEquals(msg, assertThrows(expected, executable).getMessage());
    }
}
