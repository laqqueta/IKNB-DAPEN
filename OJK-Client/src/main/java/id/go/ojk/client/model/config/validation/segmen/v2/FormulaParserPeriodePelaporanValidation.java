package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseFormulaParserValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;
import id.go.ojk.client.util.states.JenisProgramState;

import java.math.BigDecimal;

@XStreamAlias("FormulaParserPeriodePelaporanValidation")
public class FormulaParserPeriodePelaporanValidation extends BaseFormulaParserValidation {
	public FormulaParserPeriodePelaporanValidation() {
	}

	public FormulaParserPeriodePelaporanValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected BigDecimal calculateFormula(FormulaParser.ParsedFormula parsed) {
		return super.calculateFormula(parsed)
				.multiply(BigDecimal.valueOf(JenisProgramState.periodePelaporan));
	}
}