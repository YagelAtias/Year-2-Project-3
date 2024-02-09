package assig3_1;

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
                        ;
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
