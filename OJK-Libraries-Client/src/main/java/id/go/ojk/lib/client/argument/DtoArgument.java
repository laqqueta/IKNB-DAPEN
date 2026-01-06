package id.go.ojk.lib.client.argument;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class DtoArgument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private int countArg;
	@Getter
	@Setter
	private String desc;
}
