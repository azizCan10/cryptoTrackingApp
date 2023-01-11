package com.test.cryptotrackapp.core.result;

/**
 * This class is for operations which returns no data and status is false
 */

public class ErrorResult extends Result {
	
	public ErrorResult() {
		super(false);
	}
	
	public ErrorResult(String message) {
		super(false, message);
	}
}
