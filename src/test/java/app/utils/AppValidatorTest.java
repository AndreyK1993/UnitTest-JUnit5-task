package app.utils;

import app.exceptions.TemperatureException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppValidatorTest {

    private AppValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AppValidator();
    }

    @Test
    @DisplayName("Test if temperature is in bounds.")
    void testIfTemperatureIsInBounds() throws TemperatureException {
        assertEquals("Temperature is OK. Data can be obtained.",
                validator.validateTemperature(15));
    }

    @Test
    @DisplayName("Test if invalid temperature throws exception.")
    void testIfInvalidTemperatureThrowsException() {
        TemperatureException exception = assertThrows(TemperatureException.class, () ->
                validator.validateTemperature(1000));
        assertEquals("Invalid temperature.", exception.getMessage(), "Exception message is incorrect.");
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }
}
