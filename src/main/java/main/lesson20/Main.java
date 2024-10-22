package main.lesson20;

public class Main {
    private static RunnableEx runnableEx;
    private static ThreadEx mSecondThread;

    public static void main(String[] args) {
        runnableEx = new RunnableEx();

        Thread myThread = new Thread(runnableEx);	//Создание потока "myThready"
        myThread.start();

        Thread myThread2 = new Thread(() -> System.out.println("Hello from lambda thread"));
        myThread2.start();

        mSecondThread = new ThreadEx();
        mSecondThread.start();

        Thread t = Thread.currentThread(); // получаем главный поток
        System.out.println(t.getName()); // main
    }
}
