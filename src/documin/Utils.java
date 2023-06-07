package documin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.function.Executable;

public class Utils {
    public static String[] listToArray(ArrayList<String> arr) {
        return arr.toArray(new String[arr.size()]);
    }

    public static <T extends Throwable> void assertThrowsMsg(Class<T> expected, Executable executable, String msg) {
        assertEquals(msg, assertThrows(expected, executable).getMessage());
    }
}
