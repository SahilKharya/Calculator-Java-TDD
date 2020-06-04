package cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	Calculator cal = new Calculator();

	@Test
	public void addEmptyString() {
		assertEquals(0, cal.add(""), "Sum of null values should be 0");
	}

}
