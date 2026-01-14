package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ComparisonFormValidation6")
/* Override genMessage in ComparisonFormValidation */
public class ComparisonFormValidation6 extends ComparisonFormValidation {

  public ComparisonFormValidation6() {
    super();
  }

  public ComparisonFormValidation6(String parameter) {
    super(parameter);
  }

  @Override
  public String genMessage() {
    return msgError;
  }
}
