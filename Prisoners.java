import java.util.*;

/**
 * Simulation of one game of the solitaire Prisoners. 
 */
class Prisoners {
    protected CardDeck deck;
    protected Card[][] piles;
    protected int[] points;
    protected static int nbrWins;
    protected static int nbrLosses;
    protected static int timesPlayed;
    protected static int totalPilesReady;

    /**
     * Constructor, no arguments
     */
    public Prisoners () {
		deck   = new CardDeck();
		piles  = new Card[14][4]; // pile 0 is a dummy to avoid index errors
		points = new int[14]; //nbr of correct cards in each pile
		timesPlayed ++;
		run();
    }

    private void run() {
		deck.shuffle();
		setUp();

		/* Always start with the bottom card of the King pile */
		Card current = piles[13][3]; 
		piles[13][3] = null;
			
		while (true) {
			/*
			 * Consider the pile with the same nbr as the current card.
			 * Pick the top card of that pile.  
			 */
	    	int nbr  = current.getNbr();
	    	Card tmp = piles[nbr][0];
	  		points[nbr]++;

	    	/* 
	    	 * Move each card in the current pile one step and 
	    	 * put the old card in the bottom. 
	    	 */
	    	for (int old = 1; old < 4; old++) {
				piles[nbr][old - 1] = piles[nbr][old];
	    	}
	    	piles[nbr][3] = current;
	    	current = tmp;

	    	/* 
	    	 * This occurs when there is no uncorrect cards left in 
	    	 * the King pile. 
	    	 */
	    	if (current == null) { 
	    		break;
	    	}
		}

		/* Calculate result and update stats. */	
		if (success()) {
	    	nbrWins++;
		} else {
	    	nbrLosses ++;
		}	
		totalPilesReady += pilesReady();
    }

    /**
     * Print statistics of all games played so far.
     */
    public static void printStatics() {
		System.out.println("Statistics for Prisoners:");
		System.out.println("Nbr of wins: " + nbrWins);
		System.out.println("Nbr of losses: " + nbrLosses);
		System.out.println("Average result: " + 
			((double) totalPilesReady /  timesPlayed) + " piles ready");
		System.out.println("");
    }
    
  /*********************** PRIVATE HELP FUNCTIONS **************************/

    /* Setup the game by filling the 13 piles with 4 random cards each. */
    private void setUp() {
		for (int pile = 1; pile <= 13; pile++) {
			for (int ix = 0; ix < 4; ix++) {
	    		piles[pile][3 - ix] = deck.drawCard();
	    	}
		}
    }

    /* Check if a pile is ready, i.e. contains 4 correct cards. */
    private boolean ready(int pile) {
		return points[pile] == 4;
    }

    /* Check if the solitaire has succeded. */
    private boolean success() {
		for (int nbr = 1; nbr <= 13; nbr++) {
	    	if (!ready(nbr)) {
				return false;
	    	}
		}
		return true;
    }

    /* The number of piles that are ready. */
    private int pilesReady() {
		int nbrReady = 0;
		for (int nbr = 1; nbr <= 13; nbr++) {
	    	if (ready(nbr)) {
				nbrReady++;
	    	}
		}
		return nbrReady;	
    }
}