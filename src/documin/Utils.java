package documin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.function.Executable;

public class Utils {
    public static <T extends Object> T[] listToArray(ArrayList<T> arr) {
        return (T[]) arr.toArray();
    }

    public static <T extends Throwable> void assertThrowsMsg(Class<T> expected, Executable executable, String msg) {
        assertEquals(msg, assertThrows(expected, executable).getMessage());
    }
}