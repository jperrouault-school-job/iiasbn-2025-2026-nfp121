package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
