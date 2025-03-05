package dev.gfxv.lab1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SinTest {
    private final double accuracy = 0.0001;

    @ParameterizedTest(name = "sin({0})")
    @ValueSource(doubles = {
            -2 * Math.PI, -Math.PI, -0.5 * Math.PI,
            0, 0.5 * Math.PI, Math.PI,
            1.5 * Math.PI,  2 * Math.PI
    })
    void testOnPIDots(double x) {
        assertAll(() -> assertEquals(
                Math.sin(x), Sin.calculate(x), accuracy
        ));
    }

    @ParameterizedTest(name = "sin({0}) = {1}")
    @CsvFileSource(resources = "/insidePI.csv", numLinesToSkip = 1, delimiter = ',')
    void testTableValues(double x, double y) {
        assertAll(
                () -> assertEquals(y, Sin.calculate(x), accuracy)
        );
    }

}