package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("SumFormValidation")
public class SumFormValidation extends SumValidation {

	public SumFormValidation() {
		super();
	}

	public SumFormValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected BigDecimal calculateSavedValue(int seq, String stringValue) {
		Logger logger = LoggerFactory.getLogger(SumFormValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		for (Entry<String, Map<String, String>> entry : SubmissionFormat.mapPosValueForm.entrySet()) {
			if (entry.getKey().startsWith(stringValue)) {
				BigDecimal tmp = BigDecimal.ZERO;
				try {
					String colValue = entry.getValue().get(String.valueOf(seq));
					tmp = new BigDecimal(colValue != null ? colValue : "0");
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				res = res.add(tmp);
			}
		}
		return res;
	}
}