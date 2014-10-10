package recursive.inner;

public final class SimpleKey<T> {
	private SimpleKey() {}

	public static final SimpleKey<String> KEY_STRING = new SimpleKey<String>();
	public static final SimpleKey<Integer> KEY_INTEGER = new SimpleKey<Integer>();
}
