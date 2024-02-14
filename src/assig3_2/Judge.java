package assig3_2;

/**
 * The Judge class represents a judge in the coin flipping game.
 * It extends the Thread class and implements the game logic for the judge.
 *
 * @author Yagel Atias 208905448
 * @author Slava Ignatiev 322015280
 */
public class Judge extends Thread {
    private final int MAX_FLIPS = 10;
    private GamePlay gamePlay;

    public Judge(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    /**
     * Executes the logic for the Judge in a coin flipping game.
     * The Judge makes the coin available and sleeps for a certain duration before changing the availability again.
     * The loop continues until the maximum number of flips is reached or the thread is interrupted.
     */
    @Override
    public void run() {
        while (!isInterrupted() && gamePlay.getNumOfRounds() != MAX_FLIPS) {
            try {
                gamePlay.makeCoinAvail(false);
                sleep(1000);
                gamePlay.makeCoinAvail(true);
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + "Was interrupted");
            }
        }
    }
}
