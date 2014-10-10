package card;

interface CardVisitor<E> {
	  E visit(Num n);
	  E visit(Jack j);
	  E visit(Queen q);
	  E visit(King k);
}