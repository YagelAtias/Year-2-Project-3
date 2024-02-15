package assig3_3;

/**
 * This thread is responsible for adding cucumbers to the slicer machine.
 *
 * @author Yagel Atias 208905448
 * @author Slava Ignatiev 322015280
 * github link: https://github.com/YagelAtias/Year-2-Project-3
 */
public class CucumbersThread extends Thread {
    private SlicerMachine slicerMachine;
    private int numOfSaladsToPrepare;

    /**
     * Constructor for the CucumbersThread.
     *
     * @param slicerMachine        the machine that this thread will synchronize on and add cucumbers to.
     * @param numOfSaladsToPrepare the number of salads this thread should prepare before stopping.
     */
    public CucumbersThread(SlicerMachine slicerMachine, int numOfSaladsToPrepare) {
        this.slicerMachine = slicerMachine;
        this.numOfSaladsToPrepare = numOfSaladsToPrepare;
    }

    /**
     * Continuously attempt to add cucumbers to the slicerMachine until the machine has prepared
     * the desired number of salads.
     */
    @Override
    public void run() {
        while (true) {
            synchronized (slicerMachine) {
                if (slicerMachine.getNumOfPreparedSalads() >= numOfSaladsToPrepare) {
                    break;
                }
                slicerMachine.addOneCucumber();
            }
        }
    }
}