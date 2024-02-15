package assig3_1;

/**
 * The Main class demonstrates how to use threads to execute code in a specific order.
 * Three threads, t1, t2, and t3, are created and synchronized using a common lock object.
 * - Thread t1: prints "Code of A" and sets t1Finished to true, t3Finished to false, and t2Finished to false. Then notifies all waiting threads.
 * - Thread t2: waits until t1Finished becomes true, then prints "Code of B" and sets t2Finished to true. Then notifies all waiting threads and waits for 250 milliseconds.
 * - Thread t3: waits until both t1Finished and t2Finished become true, then prints "Code of C" and sets t1Finished to false, t3Finished to true, and t2Finished to true.
 * @author Yagel Atias 208905448
 * @author Slava Ignatiev 322015280
 * github link: https://github.com/YagelAtias/Year-2-Project-3
 */
public class Main {
    static boolean t1Finished = false;
    static boolean t2Finished = true;
    static boolean t3Finished = true;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (!t3Finished) {
                            lock.wait();
                        }
                        Thread.sleep(500);
                        System.out.println("Code of A");

                        t1Finished = true;
                        t3Finished = false;
                        t2Finished = false;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (!t1Finished) {
                            lock.wait();
                        }
                        Thread.sleep(500);
                        System.out.println("Code of B");
                        t2Finished = true;
                        lock.notifyAll();
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!(t1Finished && t2Finished)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Code of C");
                    t1Finished = false;
                    t3Finished = true;
                    t2Finished = true;
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
