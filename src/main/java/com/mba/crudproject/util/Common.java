package com.mba.crudproject.util;

/**
 * Common The purpose of common class to have all static common method thats we
 * will use in the entire project.
 * 
 * @author m.bassam
 * 
 */
public class Common {

	/**
	 * Is blank or null method Check the value of the sting is blank or null
	 * 
	 * 
	 * @param value String value
	 * @return true if the string value is blank or null
	 */
	public static boolean isBlankOrNull(String value) {

		if (value != null && !value.equals("")) {
			return false;
		}
		return true;
	}
}
