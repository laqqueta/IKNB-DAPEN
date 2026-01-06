package id.go.ojk.lib.client.model;

public class EvenOdd {
	
	volatile private boolean even = false;
	
	public synchronized boolean next(){
		even = !even;
		return even;
	}
	
	public synchronized String nextCssClass(){
		String result =  next() ? "even" : "odd";
		return result;
	}

}
