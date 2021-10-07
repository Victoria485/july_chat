package Homework4;
public class ABC {
    private static final Object mon1 = new Object();
    static int flag = 1;
    public static void main(String[] args) {
        waitNotifyExample();
    }
    private static void waitNotifyExample() {
        new Thread(ABC::A).start();
        new Thread(ABC::B).start();
        new Thread(ABC::C).start();
    }
    static void A() {
        synchronized (mon1) {
            try {
                for (int i = 1; i <= 5; i++) {
                    while (flag != 1) {
                        mon1.wait();
                    }
                    System.out.print("A");
                    flag = 2;
                    mon1.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static void B() {
        synchronized (mon1) {
            try {
                for (int i = 1; i <= 5; i++) {
                    while (flag != 2) {
                        mon1.wait();
                    }
                    System.out.print("B");
                    flag = 3;
                    mon1.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static void C() {
        synchronized (mon1) {
            try {
                for (int i = 1; i <= 5; i++) {
                    while (flag != 3) {
                        mon1.wait();
                    }
                    System.out.print("C");
                    flag = 1;
                    mon1.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}