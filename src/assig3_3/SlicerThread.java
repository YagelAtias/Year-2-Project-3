package assig3_3;

/**
 * Thread for slicing vegetables, which contributes to salad preparation.
 * It uses a slicer machine to slice vegetables until a certain number of salads have been prepared.
 *
 * @author Yagel Atias 208905448
 * @author Slava Ignatiev 322015280
 */
public class SlicerThread extends Thread {
    private SlicerMachine slicerMachine;
    private final int saladsToPrepare;

    /**
     * Constructor for the SlicerThread.
     * Initializes the slicer machine and the number of salads to prepare.
     *
     * @param slicerMachine   the slicer machine to use for slicing vegetables
     * @param saladsToPrepare the number of salads to prepare
     */
    public SlicerThread(SlicerMachine slicerMachine, int saladsToPrepare) {
        this.slicerMachine = slicerMachine;
        this.saladsToPrepare = saladsToPrepare;
    }

    /**
     * The run method of this thread.
     * This method continuously slices vegetables until the required number of salads have been prepared.
     * If the number of prepared salads has reached the required amount, the thread is interrupted.
     */
    @Override
    public void run() {
        while (slicerMachine.getNumOfPreparedSalads() < saladsToPrepare) {
            slicerMachine.sliceVegetables();
        }
        this.interrupt();
    }
}