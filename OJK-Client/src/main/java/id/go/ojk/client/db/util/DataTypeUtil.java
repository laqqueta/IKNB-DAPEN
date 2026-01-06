package id.go.ojk.client.db.util;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.config.Regex;

public class DataTypeUtil {
  public static String getRegexPattern(SubmissionField field) {
    SimpleValidation sv = field.getSimpleValidation();
    if(sv.getDataType() == DataType.refTable) {
      return SimpleValidation.patternAlfaNumeric.getPattern();
    }
    Regex regex = sv.getRegex();
    if(regex == SimpleValidation.patternAll) {
      return ".*";
    }
    // replace ' with ''
    return StringUtils.replace(regex.getPattern(), "'", "''");
  }

  public static String getRegexErrorMessage(SubmissionField field) {
    SimpleValidation sv = field.getSimpleValidation();
    if(sv.getDataType() == DataType.refTable) {
      return SimpleValidation.patternAlfaNumeric.getDesc();
    }
    return sv.getRegex().getDesc();
  }
}
