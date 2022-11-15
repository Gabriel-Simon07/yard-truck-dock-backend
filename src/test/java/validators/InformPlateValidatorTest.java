package validators;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import yard.truckdock.core.validators.InformPlateValidator;

public class InformPlateValidatorTest {

    @Test
    public void plateShouldReturnFalseWhyPlateHasFourLetters() {
        InformPlateValidator informPlateValidator = new InformPlateValidator();
        informPlateValidator.validPlate("abgh256");
        Assert.hasText("Informed plate is incorrect!", "Informed plate is incorrect!");
    }

            //placa com mais de quatro letras
            //placa com mais de 5 numeros
            //placa com 8 caracteres
}
