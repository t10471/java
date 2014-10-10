package hierarchy;

/** 型を表現するためのインターフェース */
public interface ValueType<X, V extends Value<X, V, T>, T extends ValueType<X, V, T>> {
	V getMax();
	V getMin();
}