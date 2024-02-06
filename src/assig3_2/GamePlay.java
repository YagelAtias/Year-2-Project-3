package assig3_2;

import java.util.Random;

public class GamePlay {
    private Random rand;
    private boolean coin_available_;
    public static int rounds_counter_ = 0;

    public void makeCoinAvail(boolean val) {
        coin_available_ = val;
        notifyAll();
    }

    public int flipCoin() {
        while (!coin_available_) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + " is waiting for coin");
            } catch (InterruptedException e) {
                System.out.println("Coin flip was interrupted");
            }
        }
        makeCoinAvail(false);
        System.out.println(Thread.currentThread().getName() + " is flipping coin");
        rounds_counter_++;
        int result = rand.nextInt(2);
        makeCoinAvail(true);
        return result;
    }

    public static int getNumOfRounds() {
        return rounds_counter_;
    }

}
