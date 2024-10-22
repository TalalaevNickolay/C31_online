package main.lesson20.sleep_join;

public class Join2 {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Method main begins");
//        Thread thread = new Thread(new Worker());
//        thread.start();
//        thread.join();
//        System.out.println("Method main ends");
//
//        System.out.println("Method main begins");
//        Thread thread1 = new Thread(new Worker());
//        thread1.start();
//        thread1.join(1500);
//        System.out.println("Method main ends");

        System.out.println("Method main begins");
        Thread thread3 = new Thread(new Worker());
        System.out.println(thread3.getState());
        System.out.println(thread3.isAlive());// >> NEW
        thread3.start();
        System.out.println(thread3.getState()); // >> RUNNABLE
        System.out.println(thread3.isAlive());
        thread3.join();
        System.out.println(thread3.getState()); // >> TERMINATED
        System.out.println(thread3.isAlive());
        System.out.println("Method main ends");
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work ends");
    }
}
