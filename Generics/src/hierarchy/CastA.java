package hierarchy;

public class CastA<T extends CastA<T>> {
	@SuppressWarnings("unchecked")
	public T getThis() {
		return (T) this;
	}
}