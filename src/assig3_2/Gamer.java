package assig3_2;

/**
 * The Gamer class represents a player in the coin flipping game.
 * It extends the Thread class and implements the game logic for playing the game.
 *
 * @author Yagel Atias 208905448
 * @author Slava Ignatiev 322015280
 */
public class Gamer extends Thread {
    private int goodFlipCounts;
    private final GamePlay gamePlay;
    private static final int MAX_FlIPS = 10;

    /**
     * Constructs a new Gamer with the specified GamePlay and name.
     *
     * @param gamePlay the GamePlay object representing the game logic and state
     * @param name     the name of the player
     */
    public Gamer(GamePlay gamePlay, String name) {
        this.gamePlay = gamePlay;
        setName(name);
    }

    /**
     * The play() method represents the game logic for a player in the coin flipping game.
     * It continuously flips a coin until the game is interrupted or the maximum number of flips is reached.
     */
    public void play() {
        while (!isInterrupted() && gamePlay.getNumOfRounds() != MAX_FlIPS) {
            try {
                goodFlipCounts += gamePlay.flipCoin();
                System.out.println(getName() + "'s good flips: " + goodFlipCounts);
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " Was interrupted");
            }
        }
    }

    /**
     * Retrieves the score of the player which means how many times did the player flip tails.
     *
     * @return the score of the player as an integer
     */
    public int getScore() {
        return goodFlipCounts;
    }

    @Override
    public void run() {
        play();
    }
}
