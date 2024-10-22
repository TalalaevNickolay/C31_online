package main.lesson20.synchronised;

public class Synchronised {
    /**
     * ---------------------------------
     * Data race и synchronized методы
     * ---------------------------------
     * Data race – это проблема, которая может возникнуть когда два и более потоков обращаются к одной и той же
     * переменной и как минимум 1 поток её изменяет.
     * <p>
     * Пример метода:
     * public synchronized void abc() {
     * method body
     * }
     */

    public static void main(String[] args) {
        MyRunnableImpl1 runnable = new MyRunnableImpl1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    static int count = 0;
}

class MyRunnableImpl1 implements Runnable {
    // 1 - without synchronized
    public void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
    // 2 - synchronized (синхронизация по объекту для не статического метода)
//    public synchronized void increment() {
//        Counter.count++;
//        System.out.print(Counter.count + " ");
//    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
