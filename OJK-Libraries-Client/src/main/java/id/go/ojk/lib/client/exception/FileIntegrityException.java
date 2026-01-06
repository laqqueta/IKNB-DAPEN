package id.go.ojk.lib.client.exception;

public class FileIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 4507977361896475589L;

	public FileIntegrityException(String message){
		super(message);
	}

	public FileIntegrityException(String message, Throwable e){
		super(message, e);
	}

}
