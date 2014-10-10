package card;

interface CardVisitorInteger extends CardVisitor<Integer> {
	Integer visit(Num n);

	Integer visit(Jack j);

	Integer visit(Queen q);

	Integer visit(King k);
}