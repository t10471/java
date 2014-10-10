package hierarchy;


public class IntegerValueType implements ValueType<Integer, IntegerValue, IntegerValueType> {
	private static final IntegerValue MAX_VALUE = new IntegerValue(Integer.MAX_VALUE);
	private static final IntegerValue MIN_VALUE = new IntegerValue(Integer.MIN_VALUE);

	@Override
	public IntegerValue getMax() {
		return MAX_VALUE;
	}

	@Override
	public IntegerValue getMin() {
		return MIN_VALUE;
	}
}