package main.lesson20;

public class Main {
    private static RunnableEx runnableEx;
    private static ThreadEx mSecondThread;

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter(1);
        CointerThread cointerThread = new CointerThread(counter);
        Thread th1 = new Thread(cointerThread);
        Thread th2 = new Thread(cointerThread);
        Thread th3 = new Thread(cointerThread);
        Thread th4 = new Thread(cointerThread);
        Thread th5 = new Thread(cointerThread);
        th1.start();
        th1.join();
        th2.start();
        th2.join();
        th3.start();
        th3.join();
        th4.start();
        th4.join();
        th5.start();
        th5.join();

//        runnableEx = new RunnableEx();
//
//        Thread myThread = new Thread(runnableEx);	//Создание потока "myThready"
//        myThread.start();
//
//        Thread myThread2 = new Thread(() -> System.out.println("Hello from lambda thread"));
//        myThread2.start();
//
//        mSecondThread = new ThreadEx();
//        mSecondThread.start();
//
//        Thread t = Thread.currentThread(); // получаем главный поток
//        System.out.println(t.getName()); // main
    }
}
