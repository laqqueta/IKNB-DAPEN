package id.go.ojk.lib.client.exception;

import id.go.ojk.lib.client.exception.SlikException;

public class ValidationErrorException extends SlikException {

	private static final long serialVersionUID = 4507977361896475589L;

	public ValidationErrorException(String message){
		super(message);
	}

	public ValidationErrorException(String message, Throwable e){
		super(message, e);
	}

}
