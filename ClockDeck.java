import java.util.*;

/**
 * A special CardDeck used for the solitaire Clock.
 */ 
class ClockDeck extends CardDeck{
    
    /**
     * Refill the deck with one of the piles from Clock.
     * The pile is emptied. 
     *
     * @param matrix	all the piles from Clock
     * @param ix		the index of the pile
     */
    public void refill (Card[][] matrix, int ix) {

		for (int k = 0; k < 52; k++) { // 52 = maximum size of the pile 
	    	
	    	Card current = matrix[ix][k];
	    	
	    	/* Ignore empty indicies in the pile. */ 
	    	if (current != null) {
				deck.add(current);
				current = null;
	    	}
		}
    }
}