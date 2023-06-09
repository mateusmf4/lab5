package documin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.function.Executable;

public class TestUtils {
    public static <T extends Throwable> void assertThrowsMsg(Class<T> expected, Executable executable, String msg) {
        assertEquals(msg, assertThrows(expected, executable).getMessage());
    }
}
