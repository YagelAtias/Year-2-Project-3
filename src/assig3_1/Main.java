package assig3_1;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("t1"));
        Thread t2 = new Thread(new MyThread("t2"));
        Thread t3 = new Thread(new MyThread("t3"));
        t1.start();
        t2.start();
        t3.start();
    }
}