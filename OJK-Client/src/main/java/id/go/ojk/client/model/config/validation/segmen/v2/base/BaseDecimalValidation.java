package id.go.ojk.client.model.config.validation.segmen.v2.base;

public abstract class BaseDecimalValidation extends BaseRowValidation {
	protected int scale;

	protected BaseDecimalValidation() {
		super();
	}

	protected BaseDecimalValidation(String parameter) {
		super(parameter);
	}
	
	@Override
	public BaseDecimalValidation initialized() {
		super.initialized();
		scale = getIntParameter("scale");
		return this;
	}
}