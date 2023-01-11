package com.test.cryptotrackapp.core.result;

import lombok.Getter;

/**
 * This class is base of Result classes
 *
 * @author can
 */

@Getter
public class Result {
	private boolean status;
	private String message;

	public Result(boolean status) {
		this.status = status;
	}

	public Result(boolean status, String message) {
		this(status);
		this.message = message;
	}
}
