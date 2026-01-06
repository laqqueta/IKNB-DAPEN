package id.go.ojk.lib.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tupple3<A, B, C> {
	private A a;
	private B b;
	private C c;
	
	public Tupple3(A a, B b, C c){
		setA(a);
		setB(b);
		setC(c);
	}

}
