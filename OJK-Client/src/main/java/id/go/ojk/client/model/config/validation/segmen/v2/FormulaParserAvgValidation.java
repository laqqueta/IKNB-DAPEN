package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseFormulaParserValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParserV2;

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
	protected BigDecimal calculateFormula(FormulaParserV2.ParsedFormula parsed) {
		return super.calculateFormula(parsed)
				.divide(new BigDecimal(avgDivision), scale, RoundingMode.HALF_UP);
	}
}