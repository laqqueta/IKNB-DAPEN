package id.go.ojk.client.db;

import static id.go.ojk.client.model.config.SimpleValidation.*;

import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.config.Regex;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

// RE2 regex <-> Java regex
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ERe2Regex {
  RE2_ALL(patternAll, ".*"),
  RE2_ALFANUMERIC(patternAlfaNumeric, "[a-zA-Z0-9]+"),
  RE2_ALFA(patternAlfa, "[a-zA-Z]+"),
  RE2_DATE(patternDate, "\\d{8}"),
  RE2_NUMERIC(patternNumeric, "[\\d]+"),
  RE2_NUMERIC_NEGATIVE(patternNumericNegatif, "^[\\-]??[0-9]+$"),
  RE2_PATTERN_NAME_5(PATTERN_NAME_5, "[a-zA-Z0-9/\\-'',.\\\"()#]+"),
  RE2_PATTERN_NAME_6(PATTERN_NAME_6, "[a-zA-Z0-9 ,.'']+"),
  ;

  @Getter
  private Regex regex;
  @Getter
  private String pattern;

  public static ERe2Regex getRegex(Regex regex) {
    if(regex == null)
      return RE2_ALL;

    for (ERe2Regex eDataType : ERe2Regex.values()) {
      if(eDataType.getRegex().getPattern().equals(regex.getPattern())) {
        return eDataType;
      }
    }
    throw new SlikException("Regex " + regex.getPattern() + " not implemented");
  }
}
