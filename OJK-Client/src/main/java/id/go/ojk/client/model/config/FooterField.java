package id.go.ojk.client.model.config;

import java.text.DecimalFormat;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("FooterField")
public class FooterField {
	@XStreamAsAttribute
	private Integer number;
	@XStreamAsAttribute
	private String code;
	@XStreamAsAttribute
	private String name;
	private SimpleValidation simpleValidation;

	public FooterField() {
	}

	public FooterField(Integer number, String code, String name, SimpleValidation simpleValidation) {
		setNumber(number);

		if (code != null)
			setCode(code);
		else
			setCode("F" + new DecimalFormat("00").format(number));

		setName(name);
		setSimpleValidation(simpleValidation);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SimpleValidation getSimpleValidation() {
		return simpleValidation;
	}

	public void setSimpleValidation(SimpleValidation simpleValidation) {
		this.simpleValidation = simpleValidation;
	}
}
