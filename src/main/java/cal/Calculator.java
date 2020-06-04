package cal;

public class Calculator {

	public int Add(String value) {
		if(value.isEmpty()) {
			return 0;
		} else {
			return Integer.parseInt(value);
		}
		
	}
	
	

}
