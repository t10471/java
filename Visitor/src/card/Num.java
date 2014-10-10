package card;

class Num implements CardInteger {
	final int value;

	Num(int v) {
		value = v;
	}

	public Integer accept(CardVisitorInteger v) {
		return v.visit(this);
	}
}
