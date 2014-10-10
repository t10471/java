package recursive.inner;

public class Group1 extends GroupKey<Group1> {
	private static final Group1 singleton = new Group1();
	public static final Group1.Key<String> GROUP_STRING = singleton.new Key<String>();
	public static final Group1.Key<Integer> GROUP_INTEGER = singleton.new Key<Integer>();
}