package cal;

public class Calculator {

	public int Add(String value) {
		if (value.isEmpty()) { // add null string
			return 0;
		} else if (value.contains(",")) { // for two numbers seperated by comma
			String[] numbers = value.split(",");
			return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
		} else {
			return Integer.parseInt(value);
		}

	}

}
