package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseFormulaParserValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;

import java.math.BigDecimal;

@XStreamAlias("FormulaParserTanggalAuditValidation")
public class FormulaParserTanggalAuditValidation extends BaseFormulaParserValidation {
	protected String auditRow;
	protected String auditCol;
	protected String formComparator;

	public FormulaParserTanggalAuditValidation() {
	}

	public FormulaParserTanggalAuditValidation(String parameter) {
		super(parameter);
	}

	@Override
	public BaseFormulaParserValidation initialized() {
		super.initialized();

		auditRow = getStringParameter("auditRow");
		auditCol = getStringParameter("auditCol");
		formComparator = getStringParameter("formComparator");

		return this;
	}

	@Override
	protected BigDecimal calculateFormula(FormulaParser.ParsedFormula parsed) {
		String auditValue = SubmissionFormat.getFormValue(formComparator + auditRow, auditCol);
		if (auditValue == null) return BigDecimal.ZERO;

		return super.calculateFormula(parsed)
				.multiply(new BigDecimal(auditValue.substring(4, auditValue.length()-2)));
	}
}