package com.test.cryptotrackapp.core.result;

/**
 * This class is for operations which returns no data and status is true
 */

public class SuccessResult extends Result {

	public SuccessResult() {
		super(true);
	}
	
	public SuccessResult(String message) {
		super(true, message);
	}
}
