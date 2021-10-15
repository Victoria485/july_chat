package Homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class Homework6Test {
    @MethodSource("generateSomeCasesForArrayAfterTheLast4Method")
    @ParameterizedTest
    void arrayAfterTheLast4Test(int[] array, int [] newArray) {
        Assertions.assertArrayEquals(newArray, Homework6.arrayAfterTheLast4(array));
    }
    @Test
    void arrayAfterTheLast4TestWithException() {
        Assertions.assertThrows(RuntimeException.class, () -> Homework6.arrayAfterTheLast4(new int[] {1, 1, 1, 1}));
    }
    public static Stream<Arguments> generateSomeCasesForArrayAfterTheLast4Method() {
        List<Arguments> list = new LinkedList<>();
        list.add(Arguments.arguments(new int[] {1, 2, 3, 4, 5, 6}, new int[] {5, 6}));
        list.add(Arguments.arguments(new int[] {4, 4, 3, 4, 5, 6}, new int[] {5, 6}));
        list.add(Arguments.arguments(new int[] {4, 4, 3, 4, 5, 4}, new int[] { }));
        return list.stream();
    }
    @MethodSource("generateSomeCasesForArrayWith1and4Method")
    @ParameterizedTest
    void arrayWith1and4(int[] array, boolean i) {
        Assertions.assertEquals(i, Homework6.arrayWith1and4(array));
    }
    public static Stream<Arguments> generateSomeCasesForArrayWith1and4Method() {
        List<Arguments> list = new LinkedList<>();
        list.add(Arguments.arguments(new int[] {1, 2, 3, 4, 5, 6}, false));
        list.add(Arguments.arguments(new int[] {1, 1, 1, 1}, false));
        list.add(Arguments.arguments(new int[] {4, 4, 4, 4}, false));
        list.add(Arguments.arguments(new int[] {1, 1, 4, 4}, true));
        return list.stream();
    }
}