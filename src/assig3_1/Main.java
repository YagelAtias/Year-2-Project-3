package assig3_1;

public class Main {
    static volatile int currentTurn = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = createThread('A', 1, 2);
        Thread t2 = createThread('B', 2, 3);
        Thread t3 = createThread('C', 3, 1);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
    }

    private static Thread createThread(char name, int waitTurn, int nextTurn) {
        return new Thread(() -> {
            while (true) {
                while (currentTurn != waitTurn) ;
                printStatusAndSleep(name);
                currentTurn = nextTurn;
            }
        });
    }

    private static void printStatusAndSleep(char name) {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + " is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted");
            }
        }
    }
}