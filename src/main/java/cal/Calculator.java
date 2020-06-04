package cal;

public class Calculator {

	public int Add(String value) {
		if (value.isEmpty()) {
			// add null string
			return 0;
		} else {
			return sumOfDelimitorSeparatedNumbers(value);
		}

	}

	private int sumOfDelimitorSeparatedNumbers(String value) {
		int sum = 0;
		// add unknown numbers separated by delimiter (comma / new line)
		String[] numbers = value.split(",|\n");
		for (int i = 0; i < numbers.length; i++) {
			int a = Integer.parseInt(numbers[i]);
			sum += a;
		}
		return sum;
	}

}
