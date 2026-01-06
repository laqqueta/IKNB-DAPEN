package id.go.ojk.lib.client.model;

public class ObjectHolder <O> {
	volatile private O object;
	
	public synchronized O getObject() {
		return object;
	}
	
	public synchronized void setObject(O object) {
		this.object = object;
	}
}
