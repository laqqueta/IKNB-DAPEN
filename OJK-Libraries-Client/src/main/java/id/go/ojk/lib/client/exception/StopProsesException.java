package id.go.ojk.lib.client.exception;

public class StopProsesException extends RuntimeException {

	private static final long serialVersionUID = 4507977361896475589L;

	public StopProsesException(String message){
		super(message);
	}

	public StopProsesException(String message, Throwable e){
		super(message, e);
	}

}
