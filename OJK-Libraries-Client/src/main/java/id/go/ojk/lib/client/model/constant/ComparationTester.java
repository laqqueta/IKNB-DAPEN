package id.go.ojk.lib.client.model.constant;

public interface ComparationTester<V>{
	boolean test(V v1, V v2);
}