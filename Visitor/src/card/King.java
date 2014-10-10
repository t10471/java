package card;

class King implements CardInteger {
	public Integer accept(CardVisitorInteger v) {
		return v.visit(this);
	}
}
