package observer;

/**
 * イベント
 * @author tn
 *
 */
public class UserCommitted extends Event {
	private User mUser;
	public UserCommitted(User user) {
		mUser = user;
	}
}