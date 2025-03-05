package dev.gfxv.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SelectionSortTest {

    @ParameterizedTest(name = "input={0}, expected={1}")
    @MethodSource("sortTestCases")
    void testSort(int[] input, int[] expected) {
        SelectionSort.sort(input);
        Assertions.assertArrayEquals(expected, input);
    }

    private static Stream<Arguments> sortTestCases() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{5}, new int[]{5}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{4, 4, 2, 2}, new int[]{2, 2, 4, 4}),
                Arguments.of(new int[]{-3, 0, 7, -5}, new int[]{-5, -3, 0, 7}),
                Arguments.of(new int[]{3, 1, 4, 1, 5}, new int[]{1, 1, 3, 4, 5})
        );
    }
}