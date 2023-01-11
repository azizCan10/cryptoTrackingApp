package com.test.cryptotrackapp.core.result;

/**
 * This class is for operations which returns data and status is true
 */

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}

	public SuccessDataResult(T data) {
		super(data, true);
	}
	
	public SuccessDataResult(String message) {
		super(null, true, message);
	}
	
	public SuccessDataResult() {
		super(null, true);
	}
}
