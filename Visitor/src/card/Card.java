package card;

interface Card<E, V extends CardVisitor<E>> {
	  E accept(V v);
}
