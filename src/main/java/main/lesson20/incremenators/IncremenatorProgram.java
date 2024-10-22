package main.lesson20.incremenators;

public class IncremenatorProgram {
    public static int mValue = 0;           //Переменая, которой оперирует инкременатор
    static Incremenator incremenator;    //Объект побочного потока

    public static void main(String[] args) {
        incremenator = new Incremenator();    //Создание потока

        System.out.print("Значение = ");

        incremenator.start();

        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000); //Ожидание в течении i*2 сек.
            } catch (InterruptedException e) {}
            incremenator.changeAction();    //Переключение действия
        }
        incremenator.finish();    //Инициация завершения побочного потока
    }
}
