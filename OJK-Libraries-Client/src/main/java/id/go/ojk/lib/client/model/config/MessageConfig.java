package id.go.ojk.lib.client.model.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageConfig {
	private String code;
	private String defValue;
}
