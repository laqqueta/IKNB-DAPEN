package id.go.ojk.client.db.validation;

import java.util.Comparator;

import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.exception.SlikException;

public class ValidationResultComparator implements Comparator<ValidationResult>{
  private final EValidationResultOrder orderBy;
  @SuppressWarnings("unused")
  private final int direction;

  private ValidationResultComparator(EValidationResultOrder orderBy, int direction) {
    this.orderBy = orderBy;
    this.direction = direction;
  }
  
  public static ValidationResultComparator createOrderByLineNumber() {
    return new ValidationResultComparator(EValidationResultOrder.LINE_NUMBER, 0);
  }

  @Override
  public int compare(ValidationResult result1, ValidationResult result2) {
    switch (orderBy) {
      case LINE_NUMBER:
        return Integer.compare(result1.lineNumber, result2.lineNumber);
      default:
        break;
    }
    throw new SlikException("Sort order not supported :" + orderBy);
  }
}
