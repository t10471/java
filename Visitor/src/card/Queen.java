package card;

class Queen implements CardInteger {
	public Integer accept(CardVisitorInteger v) {
		return v.visit(this);
	}
}
