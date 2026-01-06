package id.go.ojk.conf.client;

public interface IBuilder {
	void init();
	String buildAll();
	void testBundle(String filename);
}
