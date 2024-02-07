package assig3_2;

public class Gamer extends Thread {
    private int goodFlipCounts;
    private final GamePlay gamePlay;

    public Gamer(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    public void play() {
        while (!isInterrupted()) {
            try {
                goodFlipCounts += gamePlay.flipCoin();
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " Was interrupted");
            }
        }
    }
    public int getScore(){
        return goodFlipCounts;
    }
}
