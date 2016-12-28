/**
 * 
 */
package com.co.rappi.test.cubesummation.validate;

/**
 * @author Andrés Lavado
 *
 */
public class TestCaseValidator {
	
	public static boolean validateInteger(String value){
		try {
			Integer number = Integer.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
