package id.go.ojk.client.api;

import java.io.Serializable;

public interface IApi<T extends Serializable> {
	
	Object sendReceive(T dtoRequest);

}
