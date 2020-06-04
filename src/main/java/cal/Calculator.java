package cal;

public class Calculator {

	public int Add(String value) {
		String delimiter;
		if (value.isEmpty()) {
			// add null string
			return 0;
		}
		if (value.startsWith("//")) {
			String[] exp = value.split("\n", 2);
			delimiter = exp[0].substring(2);
			value = exp[1];
			System.out.println(exp[1]+" df");
			System.out.println(exp[0].substring(2)+ "as");
			int sum = 0;
			// add unknown numbers separated by delimiter (comma / new line)
			String[] numbers = value.split(delimiter);
			for (int i = 0; i < numbers.length; i++) {
				int a = Integer.parseInt(numbers[i]);
				System.out.println(" a = " + numbers[i]);
				sum += a;
			}
			return sum;
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
