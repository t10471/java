package wrapper;

public abstract class ValueType<X> {
	public abstract Value getMax();

	public abstract Value getMin();

	public class Value {
		public ValueType<X> getValueType() {
			return ValueType.this;
		}

		private X value;

		public Value(X value) {
			this.value = value;
		}

		public X getValue() {
			return this.value;
		}
	}
}