package dev.gfxv.lab1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class ZaphodTest {

    @ParameterizedTest
    @MethodSource("walkSpeedCases")
    void testWalk(double speed, String expectedMessage) {
        assertDoesNotThrow(() -> {
            Zaphod z = new Zaphod(Emotion.FINE, speed);
            assertEquals(expectedMessage, z.walk());
        });
    }

    private static Stream<Arguments> walkSpeedCases() {
        return Stream.of(
                Arguments.of(1, "Zaphod is walking"),
                Arguments.of(9.9, "Zaphod is walking"),
                Arguments.of(10, "Zaphod is walking fast!"),
                Arguments.of(10.1, "Zaphod is walking fast!"),
                Arguments.of(20, "Zaphod is walking fast!")
        );
    }


    @ParameterizedTest
    @MethodSource("emotionCases")
    void testTemperatureMessages(Emotion e, Emotion expectedEmotion) {
        Zaphod z = new Zaphod(e, 1);
        assertEquals(expectedEmotion, z.getEmotion());
    }

    private static Stream<Arguments> emotionCases() {
        return Stream.of(
                Arguments.of(Emotion.DETERMINISTIC, Emotion.DETERMINISTIC),
                Arguments.of(Emotion.NERVOUS, Emotion.DETERMINISTIC),
                Arguments.of(Emotion.FINE, Emotion.FINE)
        );
    }


    @ParameterizedTest
    @ValueSource(doubles = {
            -999, -10, -0.01
    })
    void testInvalidSpeed(double s) {
        assertThrows(IllegalArgumentException.class, () -> new Zaphod(Emotion.FINE, s));
    }
}