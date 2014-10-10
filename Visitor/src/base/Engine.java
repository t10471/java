package base;

class Engine {
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}