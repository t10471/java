package card;

class ToNum implements CardVisitorInteger {
	public Integer visit(Num n) {
		return n.value;
	}

	public Integer visit(Jack _) {
		return 11;
	}

	public Integer visit(Queen _) {
		return 12;
	}

	public Integer visit(King _) {
		return 13;
	}
}
