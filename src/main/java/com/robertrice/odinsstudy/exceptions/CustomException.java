package com.robertrice.odinsstudy.exceptions;

//this is how to create a custom exception. So far I have not needed one in this project.
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
	
	/*how to use (have yet to find a reason to custom make/use exception)
	 * public static void main(String[] args) throws CustomException { 
	 * throw new CustomException("This is the custom exception."); }
	 */
}