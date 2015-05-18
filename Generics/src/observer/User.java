package observer;

/**
 * イベントの発行を行う
 * @author tn
 *
 */
public class User {
	private String mFirst;
	private String mLast;

	public User(String first, String last) {
		mFirst = first;
		mLast = last;
	}

	public static void create(String first, String last) {
		User user = new User(first,last);
		Publisher.instance().publish(new UserCommitted(user));
	}

}
