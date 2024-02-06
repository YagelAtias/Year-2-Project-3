package assig3_1;

public class Main {
    static volatile int turn = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    while(turn != 1);
                    for(int i = 0; i < 3; i++){
                        System.out.println("A is running");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("A was interrupted");
                        }
                    }
                    turn = 2;
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    while(turn != 2);
                    for(int i = 0; i < 3; i++){
                        System.out.println("B is running");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("B was interrupted");
                        }
                    }
                    turn = 3;
                }
            }
        };

        Thread t3 = new Thread(){
            public void run(){
                while (true) {
                    while(turn != 3);
                    for(int i = 0; i < 3; i++){
                        System.out.println("C is running");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("C was interrupted");
                        }
                    }
                    turn = 1;
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t1.join();
    }
}