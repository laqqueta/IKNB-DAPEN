package id.go.ojk.lib.client.model.bind;

public interface CountCallback<T> {
	void updateCount(long count);
	T getKey();
}
