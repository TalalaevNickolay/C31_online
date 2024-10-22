package main.lesson20.incremenators;

class Incremenator extends Thread {
    //О ключевом слове volatile - чуть ниже
    private boolean mIsIncrement = true;
    private boolean mFinish = false;

    public void changeAction()    //Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }

    public void finish()        //Инициирует завершение потока
    {
        mFinish = true;
    }

    @Override
    public void run() {
        do {
            if (!mFinish) {    //Проверка на необходимость завершения
                if (mIsIncrement)
                    IncremenatorProgram.mValue++;
                else
                    IncremenatorProgram.mValue--;

                System.out.print(IncremenatorProgram.mValue + " ");
            } else
                return;        //Завершение потока
            try {
                Thread.sleep(500);        //Приостановка потока на 0,5 сек.
            } catch (InterruptedException e) {
            }
        }
        while (true);
    }
}
