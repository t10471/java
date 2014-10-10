package wrapper;

public class IntegerValueType extends ValueType<Integer> {
	private static IntegerValueType INSTANCE = new IntegerValueType();

	private static final ValueType<Integer>.Value MAX_VALUE =
			INSTANCE.new Value(Integer.MAX_VALUE);
	private static final ValueType<Integer>.Value MIN_VALUE =
			INSTANCE.new Value(Integer.MIN_VALUE);

	public static IntegerValueType getInstance() {
		return INSTANCE;
	}

	@Override
	public ValueType<Integer>.Value getMax() {
		return MAX_VALUE;
	}

	@Override
	public ValueType<Integer>.Value getMin() {
		return MIN_VALUE;
	}
}