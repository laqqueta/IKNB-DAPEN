package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseFormulaParserValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;

import java.math.BigDecimal;
import java.math.RoundingMode;

@XStreamAlias("FormulaParserAvgValidation")
public class FormulaParserAvgValidation extends BaseFormulaParserValidation {
	protected String avgDivision;

	public FormulaParserAvgValidation() {
	}

	public FormulaParserAvgValidation(String parameter) {
		super(parameter);
	}

	@Override
	public BaseFormulaParserValidation initialized() {
		super.initialized();

		avgDivision = getStringParameter("avgDivision");

		return this;
	}

	@Override
	protected BigDecimal calculateFormula(FormulaParser.ParsedFormula parsed) {
		return super.calculateFormula(parsed)
				.divide(new BigDecimal(avgDivision), scale, RoundingMode.HALF_UP);
	}
}