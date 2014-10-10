package hierarchy;

//型変数を減らす例の実装
public class ExecutorHashCodeStringImpl implements ExecutorHashCode<String> {
	public Integer exec(String in) {
		return in.hashCode();
	}
}