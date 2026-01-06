package id.go.ojk.lib.client.util;

public enum CrLfType {
	crLf(2), lf(1), cr(1);
	
	private int length;
	
	private CrLfType(int length){
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public static int getLength(CrLfType crLfType) {
		return crLfType == null ? 0 : crLfType.length;
	}
	
}
