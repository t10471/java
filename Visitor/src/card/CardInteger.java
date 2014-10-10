package card;

interface CardInteger extends Card<Integer, CardVisitorInteger> {
	Integer accept(CardVisitorInteger v);
}
