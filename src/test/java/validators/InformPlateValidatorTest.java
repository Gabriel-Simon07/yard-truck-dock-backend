package validators;

import org.junit.Test;
import yard.truckdock.core.validators.InformPlateValidator;

import static org.junit.Assert.*;

public class InformPlateValidatorTest {

    @Test
    public void plateShouldReturnFalseWhyPlateHasFourLetters() {
        final var valor= InformPlateValidator.validPlate("abgh256");
        assertFalse(valor);
    }

    @Test
    public void plateShouldReturnFalseWhyPlateHasFiveNumbers() {
        final var valor= InformPlateValidator.validPlate("ab22256");
        assertFalse(valor);
    }

    @Test
    public void plateShouldReturnTrueWhyPlateIsValid() {
        final var valor= InformPlateValidator.validPlate("bgh2536");
        assertTrue(valor);
    }
}
