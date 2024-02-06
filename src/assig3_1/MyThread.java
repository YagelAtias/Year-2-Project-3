package assig3_1;

public class MyThread implements Runnable{
    public static boolean waitForPrevious = false;
    private final String NAME;

    public MyThread(String name){
        NAME = name;
    }
    @Override
    public synchronized void run() {
        while(true) {
            while (waitForPrevious) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                System.out.println( NAME + " is running");
                Thread.sleep(1000);
                waitForPrevious = false;
                notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
