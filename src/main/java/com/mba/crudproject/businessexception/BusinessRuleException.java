package com.mba.crudproject.businessexception;

/**
 * Business Rule Exception.
 * 
 * Custom Exception
 * 
 * @author MBA
 *
 */
public class BusinessRuleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String message;

	/**
	 * Constructor
	 */

	public BusinessRuleException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * Setters & Getters
	 */

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
