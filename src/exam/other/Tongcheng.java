package exam.other;

import java.util.Scanner;

public class Tongcheng {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print(sc.next());

        Thread t1 = new Thread(new PrintThread_A(), "1");
        Thread t2 = new Thread(new PrintThread_B(), "2");
        Thread t3 = new Thread(new PrintThread_C(), "3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        sc.close();
    }

    public static volatile int i = 0;

    public static Object obj = new Object();

    static class PrintThread_A implements Runnable {
        public void run() {
            synchronized (obj) {
                System.out.print("_A");
            }
        }
    }

    static class PrintThread_B implements Runnable {
        public void run() {
            synchronized (obj) {
                System.out.print("_B");
            }
        }
    }

    static class PrintThread_C implements Runnable {
        public void run() {
            synchronized (obj) {
                System.out.print("_C");
            }
        }
    }
}
