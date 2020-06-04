package cal;

public class Calculator {

	public int Add(String value) {
		if (value.isEmpty()) {
			// add null string
			return 0;
		} else if (value.contains(",")) {
			int sum = 0;
			// add unknown numbers separated by comma
			String[] numbers = value.split(",");
			for (int i = 0; i < numbers.length; i++) {
				int a = Integer.parseInt(numbers[i]);
				sum += a;
			}
			return sum;
		} else {
			// sum of single number
			return Integer.parseInt(value);
		}

	}

}
