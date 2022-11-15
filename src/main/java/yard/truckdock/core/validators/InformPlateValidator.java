package yard.truckdock.core.validators;

public class InformPlateValidator {

	public static boolean validPlate(String plate) {
		if (plate.length() != 7) {
			return false;
		}
		
		if(!plateLetters(plate) || !plateNumbers(plate)) {
			return false;
		}
		return true;
	}

	private static boolean validatePlateWithMoreLetters(String plate) {
		int score = 0;
		for (int i = 0; i < plate.length(); i++) {
			if (Character.isAlphabetic(plate.charAt(i))) {
				score++;
				if(score > 3) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean plateLetters(String plate) {
		if(validatePlateWithMoreLetters(plate)) {
			return false;
		}
		String letters = plate.substring(0, 3);
		for (int i = 0; i < letters.length(); i++) {
			if (!Character.isAlphabetic(letters.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean plateNumbers(String plate) {
		String numbers = plate.substring(4, 7);
		for (int i = 0; i < numbers.length(); i++) {
			if (Character.isAlphabetic((numbers.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
}
