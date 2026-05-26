package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseFormulaParserValidation;

@XStreamAlias("FormulaParserValidation")
public class FormulaParserValidation extends BaseFormulaParserValidation {
	public FormulaParserValidation() {
	}

	public FormulaParserValidation(String parameter) {
		super(parameter);
	}
}