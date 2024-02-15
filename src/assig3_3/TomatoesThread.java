package assig3_3;

/**
 * The TomatoesThread class extends Thread and simulates a thread for slicing tomatoes.
 *
 * @author Yagel Atias 208905448
 * @author Slava Ignatiev 322015280
 * github link: https://github.com/YagelAtias/Year-2-Project-3
 */
public class TomatoesThread extends Thread {
    private SlicerMachine slicerMachine;
    private int numOfSaladsToPrepare;

    /**
     * A constructor for TomatoesThread class.
     *
     * @param slicerMachine        the machine used for slicing tomatoes
     * @param numOfSaladsToPrepare the number of salads to prepare
     */
    public TomatoesThread(SlicerMachine slicerMachine, int numOfSaladsToPrepare) {
        this.slicerMachine = slicerMachine;
        this.numOfSaladsToPrepare = numOfSaladsToPrepare;
    }

    /**
     * The run method for the thread.
     * It synchronises on the slicerMachine,
     * checks if the numOfPreparedSalads is less than required, and adds a tomato to the count.
     */
    @Override
    public void run() {
        while (true) {
            synchronized (slicerMachine) {
                if (slicerMachine.getNumOfPreparedSalads() >= numOfSaladsToPrepare) {
                    break;
                }
                slicerMachine.addOneTomato();
            }
        }
    }
}