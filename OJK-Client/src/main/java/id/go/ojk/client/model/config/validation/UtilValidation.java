package id.go.ojk.client.model.config.validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.BaseFormulaValidation;
import id.go.ojk.client.model.config.validation.segmen.MapParamSegmentValidation;
import id.go.ojk.client.model.config.validation.segmen.RatioValidation;
import id.go.ojk.lib.client.ColumnMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class UtilValidation {
	public static final String FORMULA_REGEX = "(?<=[-+/*])|(?=[-+/*])";
	public static final String FORMULA_SYMBOL = "*/+-";
	
	public static String getFormulaOperator(String operator) {
		String res = "";
		switch (operator) {
		case "e":
			res = "==";
			break;
		case "ne":
			res = "!=";
			break;
		case "lt":
			res = "<";
			break;
		case "lte":
			res = "<=";
			break;
		case "gt":
			res = ">";
			break;
		case "gte":
			res = ">=";
			break;
		default:
			break;
		}
		return res;
	}
	
	public static String getFormulaDesc(String operator) {
		String res = "";
		switch (operator) {
		case "e":
			res = "=";
			break;
		case "ne":
			res = "!=";
			break;
		case "lt":
			res = "<";
			break;
		case "lte":
			res = "<=";
			break;
		case "gt":
			res = ">";
			break;
		case "gte":
			res = ">=";
			break;
		default:
			break;
		}
		return res;
	}
	
	public static BigDecimal calculateRatio(BigDecimal nominator, BigDecimal denominator, int scale) {
		Logger logger = LoggerFactory.getLogger(RatioValidation.class);
		BigDecimal res = null;
		try {
			if (nominator != null && denominator != null) {
				if (denominator.compareTo(BigDecimal.ZERO) != 0) {
					res = nominator.divide(denominator, scale * 2, RoundingMode.HALF_UP);
				} else {
					res = BigDecimal.ZERO;
				}
				if (res != null) {
					res = res.multiply(new BigDecimal(100));
					res = res.setScale(scale, RoundingMode.HALF_UP);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			res = null;
		}
		return res;
	}
	
	public static BigDecimal calculateSavedValue(int seq, String mapKey, Set<Entry<String, Map<String, String>>> savedValue) {
		Logger logger = LoggerFactory.getLogger(BaseFormulaValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		Iterator<Entry<String, Map<String, String>>> iterator = savedValue.iterator();
		while (iterator.hasNext()) {
			Entry<String, Map<String, String>> entry = iterator.next();
			if (entry.getKey().startsWith(mapKey)) {
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
	
	public static BigDecimal toBigDecimal(String str) {
		BigDecimal res = null;
		if (StringUtils.isNotBlank(str)) {
			try {
				res = new BigDecimal(str);
			} catch (Exception e) {
			}
		}
		return res;
	}
	
	public static BigDecimal toBigDecimal(String str, String defaultValue) {
		BigDecimal res = null;
		if (StringUtils.isNotBlank(str)) {
			try {
				res = new BigDecimal(str);
			} catch (Exception e) {
			}
		}
		if (res == null) {
			res = new BigDecimal(defaultValue);
		}
		return res;
	}

	public static boolean evaluateScript(String script) {
		boolean res = false;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			res = (boolean) engine.eval(script);
		} catch (ScriptException e) {
			log.error(script, e);
		}
		return res;
	}

	public static String getArray(String[] arr, int idx, String defaultValue) {
		String res = defaultValue;
		if (arr != null && idx >= 0 && (arr.length - 1) >= idx) {
			res = arr[idx];
		}
		return res;
	}
	
	public static BigDecimal calculateRow(Map<String, Map<String, String>> savedValues, String rowFormula, int columnIdx, int scale) {
		Logger logger = LoggerFactory.getLogger(MapParamSegmentValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] formulaSplit = rowFormula.split(FORMULA_REGEX);
			if (formulaSplit != null) {
				int length = formulaSplit.length;
				String operator = "+";
				for (int i = 0; i < length; i++) {
					String formula = formulaSplit[i];
					if (!formula.isEmpty()) {
						if (FORMULA_SYMBOL.contains(formula)) {
							operator = formula;
						} else  {
							res = calculate(savedValues, formula, String.valueOf(columnIdx), operator, res);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return res.setScale(scale, RoundingMode.HALF_UP);
	}

	public static BigDecimal calculateColumn(Map<String, Map<String, String>> savedValues, String rowCode, String columnFormula, int scale) {
		Logger logger = LoggerFactory.getLogger(MapParamSegmentValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] formulaSplit = columnFormula.split(FORMULA_REGEX);
			if (formulaSplit != null) {
				int length = formulaSplit.length;
				String operator = "+";
				for (int i = 0; i < length; i++) {
					String formula = formulaSplit[i];
					if (!formula.isEmpty()) {
						if (FORMULA_SYMBOL.contains(formula)) {
							operator = formula;
						} else  {
							res = calculate(savedValues, rowCode, formula, operator, res);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return res.setScale(scale, RoundingMode.HALF_UP);
	}

	public static BigDecimal calculateColumn(Stream<Entry<String, Map<String, String>>> savedValues, String rowCode, String columnFormula, int scale) {
		Logger logger = LoggerFactory.getLogger(MapParamSegmentValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] formulaSplit = columnFormula.split(FORMULA_REGEX);
			if (formulaSplit != null) {
				int length = formulaSplit.length;
				String operator = "+";
				for (int i = 0; i < length; i++) {
					String formula = formulaSplit[i];
					if (!formula.isEmpty()) {
						if (FORMULA_SYMBOL.contains(formula)) {
							operator = formula;
						} else  {
							res = calculate(savedValues, rowCode, formula, operator, res);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return res.setScale(scale, RoundingMode.HALF_UP);
	}

	private static BigDecimal calculate(Map<String, Map<String, String>> savedValues, String rowCode, String columnIdx, String operator, BigDecimal value) {
		BigDecimal res = value;
		BigDecimal sum = SubmissionFormat.getSum(savedValues, rowCode, columnIdx);
		if (operator.equals("-")) {
			res = res.subtract(sum);
		} else if (operator.equals("*")) {
			res = res.multiply(sum);
		} else if (operator.equals("/")) {
			if (value != BigDecimal.ZERO) {
				res = res.divide(sum);
			}
		} else {
			res = res.add(sum);
		}
		return res;
	}

	private static BigDecimal calculate(Stream<Entry<String, Map<String, String>>> savedValues, String rowCode, String columnIdx, String operator, BigDecimal value) {
		BigDecimal res = value;
		BigDecimal sum = SubmissionFormat.getSum(
				savedValues.filter(v -> v.getKey().contains(rowCode)),
				columnIdx);

		if (operator.equals("-")) {
			res = res.subtract(sum);
		} else if (operator.equals("*")) {
			res = res.multiply(sum);
		} else if (operator.equals("/")) {
			if (value != BigDecimal.ZERO) {
				res = res.divide(sum);
			}
		} else {
			res = res.add(sum);
		}
		return res;
	}
	
	private static List<ColumnMap> getListColumnMap(Collection<ColumnMap> collection) {
		List<ColumnMap> res = new ArrayList<>();
		boolean retry = true;
		while (retry) {
			try {
				res.addAll(collection);
				retry = false;
			} catch (Exception e) {
				log.warn(e.getMessage(), e);
			}
		}
		return res;
	}
}
