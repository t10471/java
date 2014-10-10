package base;

class Body {
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}