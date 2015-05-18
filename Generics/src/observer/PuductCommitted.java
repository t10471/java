package observer;

/**
 * イベント
 * @author tn
 *
 */
public class PuductCommitted extends Event{

	private Product mProduct;

	public PuductCommitted(Product product) {
		mProduct = product;
	}

}
