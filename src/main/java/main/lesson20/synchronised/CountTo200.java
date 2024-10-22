package main.lesson20.synchronised;

public class CountTo200 {
    /**
     * ---------------------------------
     * Data race и synchronized методы
     * ---------------------------------
     * Data race – это проблема, которая может возникнуть когда два и более потоков обращаются к одной и той же
     * переменной и как минимум 1 поток её изменяет.
     */

    static int counter = 0;
    private static Object l;

    // 1 - without synchronized
//    public static void increment() {
//        counter++;
//    }
     //2 - synchronized (синхронизация по классу для статического метода)
    public synchronized static void increment() {
        synchronized (l){
            counter++;
        }
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter); // 1 >> 1881 >> 2000 >> 1395  // 2 >> 2000 >> 2000 >> 2000
    }
}

class R implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            CountTo200.increment();
        }
    }
}
