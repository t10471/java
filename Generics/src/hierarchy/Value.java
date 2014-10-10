package hierarchy;

/** 値を表現するためのインターフェース */
public interface Value<X, V extends Value<X, V, T>, T extends ValueType<X, V, T>> {
	T getValueType();
	X getValue();
}