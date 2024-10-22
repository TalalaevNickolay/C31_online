package main.lesson20.incremenators;

public class NewIncremenator extends Thread {

    private volatile boolean mIsIncrement = true;

    public void changeAction()
    {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {  //Проверка прерывания
                if (mIsIncrement) NewProgram.mValue++;
                else NewProgram.mValue--;

                System.out.print(NewProgram.mValue + " ");
            } else
                return;                         //Завершение потока
            try {
                Thread.sleep(1000);        //Приостановка потока на 1 сек.
            } catch (InterruptedException e) {
                return;                         //Завершение потока после прерывания
            }
        }
        while (true);
    }
}
