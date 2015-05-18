package observer;

/**
 * イベントの発行を行う
 * @author tn
 *
 */
public class Product {

	private String mName;

	public Product(String name) {
		mName = name;
	}

	public static void create(String name) {
		Product product = new Product(name);
		Publisher.instance().publish(new PuductCommitted(product));
	}

}
