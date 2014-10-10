package hierarchy;

public class IntegerValue implements Value<Integer, IntegerValue, IntegerValueType> {
	private static IntegerValueType type = new IntegerValueType();

	@Override
	public IntegerValueType getValueType() {
		return type;
	}

	private Integer value;

	public IntegerValue(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}
}