package main.lesson20;

public class RunnableEx implements Runnable {

    @Override
    public void run()        //Этот метод будет выполняться в побочном потоке
    {
        System.out.println("Привет из побочного потока!");
    }
}
