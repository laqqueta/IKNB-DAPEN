package id.go.ojk.lib.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tupple4<A, B, C, D> {
	private A a;
	private B b;
	private C c;
	private D d;
}
