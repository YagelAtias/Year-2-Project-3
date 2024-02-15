package assig3_2;

import java.util.Random;

/**
 * The GamePlay class represents the game logic and state for a coin flipping game.
 * It provides methods for flipping a coin, making the coin available, and getting the number of rounds.
 *
 * @author Yagel Atias 208905448
 * @author Slava Ignatiev 322015280
 * github link: https://github.com/YagelAtias/Year-2-Project-3
 */
public class GamePlay {
    private boolean coin_available_;
    public static int rounds_counter_ = 0;

    /**
     * Sets the availability of the coin and notifies all waiting threads.
     *
     * @param val the boolean value that indicates the availability of the coin
     */
    public synchronized void makeCoinAvail(boolean val) {
        coin_available_ = val;
        notifyAll();
    }

    /**
     * Flips a coin.
     *
     * @return 0 for heads or 1 for tails
     */
    public synchronized int flipCoin() {
        Random rand = new Random();
        while (!coin_available_) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + " is waiting for coin");
            } catch (InterruptedException e) {
                System.out.println("Coin flip was interrupted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " is flipping coin");
        rounds_counter_++;
        return rand.nextInt(2);
    }

    /**
     * Returns the number of rounds played in the game.
     *
     * @return the number of rounds played
     */
    public int getNumOfRounds() {
        return rounds_counter_;
    }

}
