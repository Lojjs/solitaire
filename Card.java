import java.util.*;

/**
 * A card from a card deck with a nbr, a suit and a text description.
 */
class Card {
    protected int nbr;
    protected int suit;

    /**
     * Constructor
     *
     * @param nbr  	the number of the card, must be in range 1-13
     * @param suit 	the suit of the card, must be in the range 1-4 where
     *             	hearts = 1, spades = 2, diamonds = 3, clubs = 4 
     */
    public Card (int nbr, int suit) {
    	
    	if (nbr >= 1 && nbr <= 13) {
			this.nbr = nbr;
    	} else {
			throw new IllegalArgumentException("Nbr must be between 1 and 13.");
    	}

		if (suit >= 1 && suit <= 4) {
			this.suit = suit;
		} else {
			throw new IllegalArgumentException("Suit must be between 1 and 4.");
		}
    }

    /**
     * Get the number of the card.
     *
     * @return an int representing the number of the card
     */
    public int getNbr() {
		return nbr;
    }

    /**
     * Get the suit of the card: 
     * hearts = 1, spades = 2, diamonds = 3, clubs = 4. 
     *
     * @return an int representing the suit of the card
     */
    public int getSuit() {
		return suit;
    }

    /**
     * Create a String description of the card on the following form:
     * "6 of clubs" and "Jack of hearts".
     *
     * @return a String describing the card
     */
    public String toString() {
		StringBuilder card = new StringBuilder();
		
		switch (nbr) {
		case 1:
	    	card.append("Ace");
	    	break;
		case 11:
	    	card.append("Jack");
	    	break;
		case 12:
	    	card.append("Queen");
	    	break;
		case 13:
	    	card.append("King");
	    	break;
		default:
			card.append(nbr);
			break;	
		}

		card.append(" of ");

		switch (suit) {
		case 1:
	    	card.append("hearts");
	    	break;
		case 2:
	    	card.append("spades");
	    	break;
		case 3:
	    	card.append("diamonds");
	    	break;
		case 4:
	    	card.append("clubs");
	    	break;
	    default:
	    	/* Impossible case */
	    	break;
		}
		return card.toString();
    }
}