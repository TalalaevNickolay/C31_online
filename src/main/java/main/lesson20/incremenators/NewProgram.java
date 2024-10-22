package main.lesson20.incremenators;

public class NewProgram {
    //Переменая, которой оперирует инкременатор
    public static int mValue = 0;

    static NewIncremenator mInc;    //Объект побочного потока

    public static void main(String[] args) {
        mInc = new NewIncremenator();    //Создание потока

        System.out.print("Значение = ");

        mInc.start();

        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000);
            } catch (InterruptedException e) {
            }
            mInc.changeAction();    //Переключение действия
        }
        mInc.interrupt();    //Прерывание побочного потока
    }
}
