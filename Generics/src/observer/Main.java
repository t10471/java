package observer;


/**
 * 実践ドメイン駆動設計にのていたサンプル
 * イベントの登録を行う
 * @author tn
 *
 */
public class Main {

	public static void main(String[] args) {
		// 匿名クラスを使用
		Publisher.instance().reset().subscribe(new Subscriber<UserCommitted>() {

			@Override
			public Class<UserCommitted> subscribedToEventType() {
				return UserCommitted.class;
			}

			@Override
			public Void handleEvent(UserCommitted event) {
				System.out.println("UserCommitted");
				return null;
			}
		}).subscribe(new Subscriber<PuductCommitted>() {

			@Override
			public Class<PuductCommitted> subscribedToEventType() {
				return PuductCommitted.class;
			}

			@Override
			public Void handleEvent(PuductCommitted event) {
				System.out.println("PuductCommitted");
				return null;
			}
		});
		User.create("first","last");
		Product.create("product");
	}

}
