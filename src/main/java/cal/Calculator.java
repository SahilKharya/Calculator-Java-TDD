package cal;

public class Calculator {

	private String delimiter = ",";

	public int Add(String value) {

		if (value.isEmpty()) {
			// add null string
			return 0;
		}
		if (value.contains("-")) {
			String num = "";
			// add unknown numbers separated by delimiter (comma / new line)
			String[] numbers = value.split(delimiter);
			for (int i = 0; i < numbers.length; i++) {
				int a = Integer.parseInt(numbers[i]);
				if (a < 0) {
					num = num + numbers[i] + ",";
				}
			}
			num = num.substring(0, num.length() - 1);
			throw new RuntimeException("negatives not allowed: " + num);
		}
		return sumValue(value);
	}

	private int sumValue(String value) {
		if (value.startsWith("//")) {
			String[] exp = value.split("\n", 2);
			delimiter = exp[0].substring(2);
			value = exp[1];
		} else {
			delimiter = ",|\n";
		}
		return sumOfDelimiterSeparatedNumbers(value, delimiter);
	}

	private int sumOfDelimiterSeparatedNumbers(String value, String delimiter) {
		int sum = 0;
		// add unknown numbers separated by delimiter (comma / new line)
		String[] numbers = value.split(delimiter);
		for (int i = 0; i < numbers.length; i++) {
			int a = Integer.parseInt(numbers[i]);
			sum += a;
		}
		return sum;
	}

}
