package assig3_3;

import java.util.Scanner;

public class Main {

    /**
     * The main method is the entry point of the program.
     * It prepares salads using a SlicerMachine and multiple threads for slicing cucumbers and tomatoes.
     *
     * @throws InterruptedException If the main thread is interrupted while waiting.
     * @author Yagel Atias 208905448
     * @author Slava Ignatiev 322015280
     */
    public static void main(String[] args) throws InterruptedException {
        SlicerMachine slicerMachine = new SlicerMachine();
        System.out.println("Please Type How Many Salads To Prepare:");
        Scanner scan = new Scanner(System.in);
        final int numOfSaladsToPrepare = scan.nextInt();
        SlicerThread slicer = new SlicerThread(slicerMachine, numOfSaladsToPrepare);
        CucumbersThread cucumbersThread = new CucumbersThread(slicerMachine, numOfSaladsToPrepare);
        TomatoesThread tomatoesThread = new TomatoesThread(slicerMachine, numOfSaladsToPrepare);
        System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");
        cucumbersThread.start();
        tomatoesThread.start();
        slicer.start();
        while (!slicer.isInterrupted()) {
            Thread.sleep(250);
        }
        System.out.println("Done");
        scan.close();
    }
}