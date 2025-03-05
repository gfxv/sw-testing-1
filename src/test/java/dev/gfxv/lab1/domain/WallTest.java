package dev.gfxv.lab1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @ParameterizedTest
    @ValueSource(doubles = {
            -999, 999, Wall.highestTemperature + 0.1, Wall.lowestTemperature - 0.1
    })
    void testInvalidTemperatures(double t) {
        assertThrows(IllegalArgumentException.class, () -> new Wall(Material.DARK_TILE, t));
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            -10, 10, Wall.highestTemperature - 0.1, Wall.lowestTemperature + 0.1
    })
    void testValidTemperatures(double t) {
        assertDoesNotThrow(() -> new Wall(Material.DARK_TILE, t));
    }

    @ParameterizedTest
    @MethodSource("temperatureMessageCases")
    void testTemperatureMessages(double t, String expectedMessage) {
        assertDoesNotThrow(() ->  {
            Wall wall = new Wall(Material.DARK_TILE, t);
            assertEquals(expectedMessage, wall.getTemperature());
        });
    }

    private static Stream<Arguments> temperatureMessageCases() {
        return Stream.of(
                Arguments.of(1, "Wall is cold!"),
                Arguments.of(15, "Wall is cold!"),
                Arguments.of(15.1, "Wall is fine"),
                Arguments.of(20, "Wall is fine"),
                Arguments.of(29.9, "Wall is fine"),
                Arguments.of(30, "Wall is hot!"),
                Arguments.of(50, "Wall is hot!")
        );
    }

}