package cal;

public class Calculator {

	private String delimiter = ",";
	private String negativeNumber = "";
	private String[] ch = new String[] { "+", "*", "?" };

	public int Add(String value) {
		// add null string
		if (value.isEmpty()) {
			return 0;
		}
		// not null values
		return sumValue(value);
	}

	// Method to check and use delimiter
	private int sumValue(String value) {
		if (value.startsWith("//")) {
			value = multipleDelimitersStartingWithExpression(value);
		} else {
			delimiter = ",|\n";
		}
		return sumOfDelimiterSeparatedNumbers(value, delimiter);
	}

	// Method for equation starting with //
	private String multipleDelimitersStartingWithExpression(String value) {
		String[] equation = value.split("\n", 2);
		delimiter = equation[0].substring(2);

		if (delimiter.startsWith("[")) {
			delimiter = delimiter.substring(1, delimiter.length() - 1);
			// 'if' there are multiple delimiters within different []
			if (delimiter.contains("][")) {
				delimiter = delimiter.replaceAll("\\]\\[", "|");
			}
			// for loop to change special meta characters in java which require escape
			// sequence
			for (String c : ch) {
				if (delimiter.contains(c)) {
					delimiter = delimiter.replaceAll("\\" + c, "\\\\" + c);
				}
			}
		}
		value = equation[1];
		return value;
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
