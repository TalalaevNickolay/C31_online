package main.lesson20.sleep_join;

/**
 * ---------------
 * Методы Thread
 * ---------------
 * Методы: setName(), getName(), setPriority(), getPriority(), sleep(), join().
 * <p>
 * ----------------------------
 * Concurrency / Parallelism
 * Asynchronous / Synchronous
 * ----------------------------
 * Concurrency означает выполнение сразу нескольких задач. В зависимости от процессора компьютера concurrency
 * может достигаться разными способами.
 * Parallelism означает выполнение 2-х и более задач в одно и то же время, т.е. параллельно. В компьютерах с
 * многоядерным процессором concurrency может достигаться за счёт parallelism.
 * <p>
 * В синхронном программировании задачи выполняются последовательно друг за другом.
 * <p>
 * В асинхронном программировании каждая следующая задача НЕ ждёт окончания выполнения предыдущей.
 * Асинхронное программирование помогает достичь concurrency.
 */
public class SleepJoinEx extends Thread {

    public static void main(String[] args) throws InterruptedException {
        // 1
//        SleepJoinEx thread2 = new SleepJoinEx();
//        SleepJoinEx thread3 = new SleepJoinEx();
//        thread2.start();
//        thread3.start();
//        System.out.println("Конец!");

        // 2 - join()
        SleepJoinEx thread1 = new SleepJoinEx();
        SleepJoinEx thread2 = new SleepJoinEx();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Конец!");
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}