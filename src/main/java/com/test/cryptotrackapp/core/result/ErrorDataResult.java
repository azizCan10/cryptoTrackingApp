package com.test.cryptotrackapp.core.result;

/**
 * This class is for operations which returns data and status is false
 */

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}
	
	public ErrorDataResult(T data) {
		super(data, false);
	}
	
	public ErrorDataResult(String message) {
		super(null, false, message);
	}
	
	public ErrorDataResult() {
		super(null, false);
	}
}
