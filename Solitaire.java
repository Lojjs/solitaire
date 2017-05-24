import java.util.*;

/**
 * Play the solitaires 100 times each and print their statistics.
 */
class Solitaire {

    public static void main(String[] args) {
        new Solitaire().run();
    }

    void run() {
		for (int i = 1; i <= 100; i++) {
			new Prisoners();
			new Clock();
		}
		Prisoners.printStatics();
		Clock.printStatics();
    }
}