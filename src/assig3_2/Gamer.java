package assig3_2;

public class Gamer extends Thread {
    private int goodFlipCounts;
    private final GamePlay gamePlay;
    private static final int MAX_FlIPS = 10;

    public Gamer(GamePlay gamePlay, String name) {
        this.gamePlay = gamePlay;
        setName(name);
    }

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
    public int getScore(){
        return goodFlipCounts;
    }
    @Override
    public void run(){
        play();
    }
}
