package id.go.ojk.lib.client.exception;

import id.go.ojk.lib.client.exception.SlikException;

public class FtpException extends SlikException {

	private static final long serialVersionUID = 4507977361896475589L;

	public FtpException(String message){
		super(message);
	}

	public FtpException(String message, Throwable e){
		super(message, e);
	}

}
