package id.go.ojk.lib.client.exception;

public class CryptoException extends SlikException {

	private static final long serialVersionUID = 4507977361896475589L;

	public CryptoException(String message){
		super(message);
	}

	public CryptoException(String message, Throwable e){
		super(message, e);
	}

}
