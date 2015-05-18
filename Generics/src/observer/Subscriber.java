package observer;

/**
 * 購読者の基底クラス
 * @author tn
 *
 */
public abstract class Subscriber<T> {
	/**
	 * イベントを識別するために必要
	 * @return
	 */
	public abstract Class<?> subscribedToEventType();

	/**
	 * 実処理
	 * @param event
	 * @return
	 */
	public abstract Void handleEvent(T event);
}
