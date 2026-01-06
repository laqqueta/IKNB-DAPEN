package id.go.ojk.lib.client.model.bind;

public interface StatusCallback {
	
	public static int disable 	= 0;
	public static int start 	= 1;
	public static int success 	= 2;
	public static int error 	= 3;
	
	void updateStatus(int status);
}
