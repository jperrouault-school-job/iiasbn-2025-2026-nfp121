package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatriceTest {
    private Calculatrice calc;

    @BeforeEach
    void initCalculatrice() {
        this.calc = new Calculatrice();
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(true);
    }

    @Test
    void shouldReturnTwelveWhenFiveAndSeven() {
        // Given
        // Calculatrice calc = new Calculatrice();
        int a = 5;
        int b = 7;

        // When
        int result = calc.additionner(a, b);

        // Then
        Assertions.assertEquals(12, result);
    }

    @Test
    void shouldReturnTenWhenOneAndNine() {
        // Given
        // Calculatrice calc = new Calculatrice();
        int a = 1;
        int b = 9;

        // When
        int result = calc.additionner(a, b);

        // Then
        Assertions.assertEquals(10, result);
    }

    @ParameterizedTest
    @CsvSource({
        "5,7,12", "1,9,10", "4,7,11"
    })
    void shouldReturnCorrectValues(int a, int b, int expected) {
        // Given
        // Calculatrice calc = new Calculatrice();

        // When
        int result = calc.additionner(a, b);

        // Then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldReturn0IfEmptyOrNull(String value) {
        // Given

        // When
        int result = calc.additionner(value);

        // Then
        Assertions.assertEquals(0, result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "2", "5", "6" })
    void shouldReturnValueWhenUniqValue(String value) {
        // Given
        int expected = Integer.parseInt(value);

        // When
        int result = calc.additionner(value);

        // Then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "12,5,19:36",
        "12;5;19:36",
        "12;5,19;8,7:51",
    }, delimiter = ':')
    void shouldReturnCorrectValues(String value, int expected) {
        // Given

        // When
        int result = calc.additionner(value);

        // Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldReturn35() {
        // Given
        String value = """
        12
        5
        18
        """;

        // When
        int result = calc.additionner(value);

        // Then
        Assertions.assertEquals(35, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "5,-4,6",
        "0,1,-10"
    })
    void shouldThrowNegativeNotAllowedExceptionIfNegative(String value) {
        // Given

        // When & Then
        Assertions.assertThrows(
            NegativeNotAllowedException.class,
            () -> calc.additionner(value)
        );
    }
}
