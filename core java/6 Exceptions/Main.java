package main;

public class Main {
	
	public static void main(String[] args) {
		//Exception handling using try-catch
        try {
	            // Checked exception
	            checkNumber(-5);
	
	            // Unchecked exception
	            int result = divide(10, 0);
	            System.out.println("Result: " + result);
	
	        } catch (NegativeNumberException e) {
	            System.err.println("Caught NegativeNumberException: " + e.getMessage());
	        } catch (ArithmeticException e) {
	            System.err.println("Caught ArithmeticException: " + e.getMessage());
	        } finally {
	            System.out.println("Execution completed.");
	        }
	    }
	
	    // Demonstrates throws (declaring a checked exception i.e. caught at compile time)
	    public static void checkNumber(int number) throws NegativeNumberException {
	        if (number < 0) {
	            throw new NegativeNumberException("Number must be non-negative.");
	        }
	        System.out.println("Number is valid: " + number);
	    }
	
	    // Demonstrates throw (manually throwing an exception i.e. caught at runtime)
	    public static int divide(int a, int b) {
	        if (b == 0) {
	            throw new ArithmeticException("Cannot divide by zero.");
	        }
	        return a / b;
	    }	
}

//Custom exception NegativeNumberException inherits from Exception
//Any checked exception is a subclass of Exception
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
