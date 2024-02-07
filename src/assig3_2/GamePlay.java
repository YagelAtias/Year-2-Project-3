package assig3_2;

import java.util.Random;

public class GamePlay {
    private boolean coin_available_;
    public static int rounds_counter_ = 0;

    public synchronized void makeCoinAvail(boolean val) {
        coin_available_ = val;
        notifyAll();
    }

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

    public int getNumOfRounds() {
        return rounds_counter_;
    }

}
