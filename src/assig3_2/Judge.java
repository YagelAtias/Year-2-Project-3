package assig3_2;

public class Judge extends Thread {
    private final int MAX_FLIPS = 10;
    private GamePlay gamePlay;
    public Judge(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    @Override
    public synchronized void run() {
        while (!isInterrupted() && gamePlay.getNumOfRounds() != MAX_FLIPS) {
            try {
                gamePlay.makeCoinAvail(false);
                sleep(1000);
                gamePlay.makeCoinAvail(true);
                sleep(500);
            } catch (InterruptedException e){
                System.out.println(getName() + "Was interrupted");
            }
        }
    }
}
