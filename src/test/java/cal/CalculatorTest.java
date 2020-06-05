package cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	public void addEmptyString() {
		assertEquals(0, calculator.Add(""), "Sum of null values should be 0");
	}

	@Test
	public void addSingleNumber() {
		assertEquals(1, calculator.Add("1"), "Sum of one value is that value only.");
		assertEquals(3, calculator.Add("3"), "Sum of one value is that value only.");
		assertEquals(17, calculator.Add("17"), "Sum of one value is that value only.");
	}

	@Test
	public void addTwoNumbersCommaSeperated() {
		assertEquals(3, calculator.Add("1,2"), "Wrong result for adding two values.");
		assertEquals(10, calculator.Add("3,7"), "Wrong result for adding two values.");
		assertEquals(29, calculator.Add("12,17"), "Wrong result for adding two values.");
	}

	@Test
	public void addMultipleNumbers() {
		assertEquals(3, calculator.Add("1,1,1"), "Wrong result for adding values.");
		assertEquals(40, calculator.Add("3,7,10,5,15"), "Wrong result for adding values.");
		assertEquals(83, calculator.Add("12,17,51,3"), "Wrong result for adding values.");
	}

	@Test
	public void addNumbersSeparatedByNewLineOrComma() {
		assertEquals(6, calculator.Add("1\n2,3"), "Wrong result for adding values.");
		assertEquals(40, calculator.Add("3,7\n15\n15"), "Wrong result for adding values.");
		assertEquals(20, calculator.Add("12\n8"), "Wrong result for adding values.");
	}

	@Test
	public void supportDifferentDelimiters() {
		assertEquals(3, calculator.Add("//;\n1;2"));
		assertEquals(3, calculator.Add("//,\n1,2"));
	}

	@Test
	public void exceptionNegativeNumber() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			calculator.Add("-5");
		});
		assertEquals("negatives not allowed: -5", exception.getMessage());
	}
	
	@Test
	public void exceptionMultipleNegativeNumbers() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			calculator.Add("-4,5,-6,23");
		});
		assertEquals("negatives not allowed: -4,-6", exception.getMessage());
	}
	
	@Test
	public void ignoreGreaterThanThousand() {
		assertEquals(15, calculator.Add("10,1030,5"));
		assertEquals(0, calculator.Add("1250,1030,2225"));

	}
}
