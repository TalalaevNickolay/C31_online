package main.lesson20;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            do {
                try {
                    Thread.sleep(500);
                    System.out.println("Еще работаю");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (true);
        });
        th1.setDaemon(true);
        th1.start();
        Thread.sleep(3000);
        System.out.println("Konec!");
    }
}
