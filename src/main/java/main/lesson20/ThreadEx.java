package main.lesson20;

public class ThreadEx extends Thread {

    @Override
    public void run()    //Этот метод будет выполнен в побочном потоке
    {
        System.out.println("Привет из побочного потока!");
    }
}
