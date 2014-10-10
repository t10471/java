package card;

class Jack implements CardInteger {
	public Integer accept(CardVisitorInteger v) {
		return v.visit(this);
	}
}
