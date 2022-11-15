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
}
