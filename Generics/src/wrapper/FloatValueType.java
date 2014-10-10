package wrapper;

public class FloatValueType extends ValueType<Float> {
	private static FloatValueType INSTANCE = new FloatValueType();

	private static final ValueType<Float>.Value MAX_VALUE =
			INSTANCE.new Value(Float.MAX_VALUE);
	private static final ValueType<Float>.Value MIN_VALUE =
			INSTANCE.new Value(Float.MIN_VALUE);

	public static FloatValueType getInstance() {
		return INSTANCE;
	}

	@Override
	public ValueType<Float>.Value getMax() {
		return MAX_VALUE;
	}

	@Override
	public ValueType<Float>.Value getMin() {
		return MIN_VALUE;
	}
}