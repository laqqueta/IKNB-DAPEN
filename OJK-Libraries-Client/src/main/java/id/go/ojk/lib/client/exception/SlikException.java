package id.go.ojk.lib.client.exception;

public class SlikException extends RuntimeException {

	private static final long serialVersionUID = 4507977361896475589L;

	public SlikException(String message){
		super(message);
	}

	public SlikException(String message, Throwable e){
		super(message, e);
	}

}
