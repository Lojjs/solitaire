import java.util.*;

/**
 * Simulation of one game of the solitaire Clock.
 */
class Clock {
    private ClockDeck deck;
    protected Card[][] piles;
    protected static int nbrWins;
    protected static int nbrLosses;
    protected static int timesPlayed;
    protected static int totalPilesReady;

    /**
     * Constructor, no arguments
     */
    public Clock () {
		deck  = new ClockDeck();
		piles = new Card[13][52];
		timesPlayed ++;
		run();
    }

    private void run() {

		deck.shuffle();
		int next = 0;
	
		/* Loop throught the piles until loss or win. */
		OuterLoop:
		while (true) {
	    	for (int k = 1; k <= 13; k++) {
		
				/* No cards left => loss */
				if (deck.isEmpty()) {
		    		nbrLosses++;
		    		break OuterLoop;
				}

				/* Check if the solitaire has succeded. */
				if (success()) {
		    		nbrWins++;
		    		break OuterLoop;
				}

				/* Skip piles that are ready. */
				if (!ready(k - 1)) {
		    
		    		/* 
		    		 * Pick the top card of the deck. 
		    		 * If its number matches the current pile,
		    		 * put the cards of the pile back in the deck.
		    		 */
		    		Card current = deck.drawCard();
		    		if (k == current.getNbr()) {
						deck.refill(piles, k - 1);
						piles[k - 1][0] = current;
					} else {
						/* Put the current card in the current pile. */
		    			piles[k - 1][next] = current;
					}
				}
	    	}
	    	next++;
		}
		/* Update for statistics. */
		totalPilesReady += pilesReady();
    }

    /**
     * Print statistics of all games played so far.
     */
    public static void printStatics() {
		System.out.println("Statistics for Clock:");
		System.out.println("Nbr of wins: " + nbrWins);
		System.out.println("Nbr of losses: " + nbrLosses);
		System.out.println("Average result: " + 
			((double) totalPilesReady /  timesPlayed) + " piles ready");
		System.out.println("");
    }

  /*********************** PRIVATE HELP FUNCTIONS **************************/
  
  	/* Check if a pile is ready i.e. its top card is correct  */
    private boolean ready(int pile){

	    if (piles[pile][0] != null) {
			if (piles[pile][0].getNbr() == pile + 1) {
		    	return true;
			}
	    }
		return false;
    }

    /* Check if the solitaire has succeded. */
    private boolean success(){
		for (int nbr = 0; nbr < 13; nbr++) {
	    	if (!ready(nbr)) {
				return false;
	    	}
		}
		return true;
    }

    /* The number of piles that are ready. */
    private int pilesReady() {
		int nbrReady = 0;
		for (int nbr = 0; nbr < 13; nbr++) {
	    	if (ready(nbr)) {
				nbrReady++;
	    	}
		}
		return nbrReady;	
   }
}