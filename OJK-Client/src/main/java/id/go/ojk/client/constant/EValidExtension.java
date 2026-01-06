package id.go.ojk.client.constant;

import java.util.Arrays;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EValidExtension {
	TXT (Arrays.asList(".txt")),
	PDF (Arrays.asList(".pdf")),
	ZIP (Arrays.asList(".zip")),
	TXT_PDF (Arrays.asList(".txt", ".pdf")),
	TXT_PDF_ZIP (Arrays.asList(".txt", ".pdf", ".zip")),
	;
	
	@Getter private List<String> extension;
	
	public String getExtensionAsString(String delimiter) {
		StringBuilder res = new StringBuilder();
		if (extension != null) {
			int len = extension.size();
			for (int i = 0; i < len; i++) {
				res.append(extension.get(i));
				if (i + 1 < len) {
					res.append(" ");
					res.append(delimiter);
					res.append(" ");
				}
			}
		}
		return res.toString();
	}
	
	public boolean validExtension(String ext) {
		return extension.contains(ext);
	}
}
