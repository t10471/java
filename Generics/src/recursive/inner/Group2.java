package recursive.inner;

public class Group2 extends GroupKey<Group2> {
	private static final Group2 singleton = new Group2();
	public static final Group2.Key<String> GROUP_STRING = singleton.new Key<String>();
	public static final Group2.Key<Integer> GROUP_INTEGER = singleton.new Key<Integer>();
}