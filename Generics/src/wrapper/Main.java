package wrapper;

public class Main {

	public static void main(String[] args) {
		IntegerValueType.Value intValue = IntegerValueType.getInstance().new Value(123);
		FloatValueType.Value floatValue = FloatValueType.getInstance().new Value(123.0F);

		System.out.printf("%d %d %d\n",
			intValue.getValue().intValue(),
			intValue.getValueType().getMin().getValue().intValue(),
			intValue.getValueType().getMax().getValue().intValue()
		);
		System.out.printf("%f %f %f\n",
			floatValue.getValue().floatValue(),
			floatValue.getValueType().getMin().getValue().floatValue(),
			floatValue.getValueType().getMax().getValue().floatValue()
		);
	}
}
