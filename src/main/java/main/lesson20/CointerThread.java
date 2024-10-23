package main.lesson20;

public class CointerThread implements Runnable {

    private Counter counter;

    public CointerThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.setCount(1);
        for(int i = 0; i < 4; i++) {
            System.out.print(counter.getCount() + " ");
            counter.increase();
        }
    }
}
