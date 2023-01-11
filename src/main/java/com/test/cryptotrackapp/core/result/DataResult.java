package com.test.cryptotrackapp.core.result;

import lombok.Getter;

/**
 * This class is base of Result classes which returns data
 */

@Getter
public class DataResult<T> extends Result {
	private T data;
	
	public DataResult(T data, boolean status, String message) {
		super(status, message);
		this.data = data;
	}

	public DataResult(T data, boolean status) {
		super(status);
		this.data = data;
	}
}
