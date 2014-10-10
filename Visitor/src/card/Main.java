package card;

import java.util.ArrayList;
import java.util.List;

public class Main {
	  public static void main(String...args) {
	    List<CardInteger> cards = new ArrayList<CardInteger>();
	    cards.add(new Num(1));
	    cards.add(new Jack());
	    int sum = 0;
	    for (CardInteger c : cards) {
	      sum = sum + c.accept(new ToNum());
	    }
	    System.out.println(sum);
	  }
	}