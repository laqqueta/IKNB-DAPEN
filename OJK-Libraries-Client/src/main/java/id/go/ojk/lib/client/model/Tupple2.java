package id.go.ojk.lib.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tupple2<A, B> {
	private A a;
	private B b;
	
	public Tupple2(A a, B b){
		setA(a);
		setB(b);
	}
}
