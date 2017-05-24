import java.util.*;

/**
 * Implementation of a card deck with functionality such as shuffling and
 * drawing cards.
 */
class CardDeck {
    protected List<Card> deck;

    /**
     * Constructor, no argumets
     */
    public CardDeck (){
		deck = new ArrayList<Card>();
		for (int nbr = 1; nbr <= 13; nbr++) {
	    	for (int suit = 1; suit <= 4; suit++) {
				Card card = new Card(nbr, suit);
				deck.add(card);
	    	}
		}
    }

    /**
     * Shuffles the card deck to a random order.
     */
    public void shuffle() {
		
		/* Make a copy of the list. */
		List<Card> tmp = new ArrayList<Card>();
		for (Card c: deck) {
	    	tmp.add(c);
		}

		/* 
		 * Put a random card from the tmp list at each pos. 
		 * in the original list. 
		 */
		Random rng = new Random();
		for (int k = 0; k < 52; k++) {
	    	Card pickedCard = tmp.remove(rng.nextInt(52-k));
	    	deck.set(k, pickedCard);
		}
    }

    /**
     * Draw the top card. The card is removed from the card deck.
     *
     * @return the Card placed first in the card deck
     */
    public Card drawCard() {
		return deck.remove(0);
    }
    
    /**
     * Check whether the card deck is empty.
     *
     * @return true if the card deck is empty, otherwise false
     */
    public boolean isEmpty() {
		return deck.size() == 0; 
    }
}