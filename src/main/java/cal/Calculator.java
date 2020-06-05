package cal;

public class Calculator {

	private String delimiter = ",";
	private String negativeNumber = "";

	public int Add(String value) {
		if (value.isEmpty()) {
			// add null string
			return 0;
		}
		return sumValue(value);
	}

	// Method to use check and use delimiter
	private int sumValue(String value) {
		if (value.startsWith("//[")) {
			String[] exp = value.split("\n", 2);
			delimiter = exp[0].substring(3, exp[0].length() - 1);
			System.out.println(delimiter);
			if (delimiter.contains("][")) {
				delimiter = delimiter.replaceAll("\\]\\[", "|");
			}
			if (delimiter.contains("*")) {
				delimiter = delimiter.replaceAll("\\*", "\\\\*");
			}
			value = exp[1];
		} else if (value.startsWith("//")) {
			String[] exp = value.split("\n", 2);
			delimiter = exp[0].substring(2);
			value = exp[1];
		} else {
			delimiter = ",|\n";
		}
		return sumOfDelimiterSeparatedNumbers(value, delimiter);
	}

	// Method to add the unknown values
	private int sumOfDelimiterSeparatedNumbers(String value, String delimiter) {
		int sum = 0;
		// add unknown numbers separated by delimiter
		String[] numbers = value.split(delimiter);
		for (int i = 0; i < numbers.length; i++) {
			int a = Integer.parseInt(numbers[i]);

			// Check for negative values and throw exception
			if (a < 0) {
				negativeNumbersException(numbers);
			} else {
				// Check for number > 1000 and skip its addition
				if (a > 1000) {
					continue;
				}
				// Add the values
				sum += a;
			}
		}
		return sum;
	}

	// Method to throw exception for any negative number and print those numbers
	private void negativeNumbersException(String[] numbers) {
		for (int j = 0; j < numbers.length; j++) {
			int b = Integer.parseInt(numbers[j]);
			if (b < 0) {
				negativeNumber = negativeNumber + numbers[j] + ",";
			}
		}
		negativeNumber = negativeNumber.substring(0, negativeNumber.length() - 1);
		throw new RuntimeException("negatives not allowed: " + negativeNumber);
	}

}
