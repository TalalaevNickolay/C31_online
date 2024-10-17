package main.lesson18;

import java.util.*;
import java.util.stream.Collectors;

public class ClassWork {
    /*
    1)Создайте список строк и напишите программу, которая использует Stream API для:
        - Преобразования всех строк в верхний регистр.
        - Фильтрации строк, длина которых больше 3 символов.
        - Сборки результатов в новый список.
        - Агрегация данных с помощью Stream

    2)Напишите метод, который принимает список чисел и возвращает сумму всех четных чисел в этом списке, используя Stream API.

    3)Создайте класс Book с полями title (String), author (String) и year (Integer).
    Напишите метод, который принимает список книг и группирует их по автору, возвращая Map<String, List<Book>>,
    где ключ — имя автора, а значение — список его книг.

    4)Создайте класс Student с полем name (String) и списком grades (List<Integer>).
    Напишите метод, который возвращает список всех оценок всех студентов, используя flatMap.

    5)Напишите метод, который принимает список строковых представлений чисел и возвращает список квадратов этих чисел.
    Используйте map для преобразования строк в числа, а затем примените map для возведения в квадрат.
     */
    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
    }

    public static void taskOne() {
        System.out.println("Task 1: ");
        List<String> names = new ArrayList<>();
        names.add("Polya");
        names.add("Nikita");
        names.add("Nikolay");
        names.add("Sasha");
        names.add("An");
        names.stream()
                .map(String::toUpperCase)
                .filter(x -> x.length() > 3)
                .toList()
                .forEach(System.out::println);
    }

    public static void taskTwo() {
        System.out.println("\n" + "Task 2: ");
        List<Integer> age = new ArrayList<>();
        age.add(5);
        age.add(7);
        age.add(4);
        age.add(19);
        age.add(8);

        OptionalInt result = age.stream()
                .sorted()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .reduce(Integer::sum);
        System.out.println("Сумма равна: " + result.getAsInt());
    }

    public static void taskThree() {
        System.out.println("\n" + "Task 3: ");
        List<Book> books = List.of(new Book("Евгений Онегин", "Пушкин", 1823),
                new Book("Капитанская дочка", "Пушкин", 1836),
                new Book("Дубровский", "Пушкин", 1841),
                new Book("Преступление и наказание", "Достоевский", 1865),
                new Book("Идиот", "Достоевский", 1867),
                new Book("Бедные люди", "Достоевский", 1844),
                new Book("Детство", "Толстой", 1852),
                new Book("Война и мир", "Толстой", 1863),
                new Book("Кавказский пленник", "Толстой", 1872));

        Map<String, List<Book>> booksAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));

        System.out.println(booksAuthor);
    }

    public static void taskFour() {
        System.out.println("\n" + "Task 4: ");
        List<Student> students = Arrays.asList(
                new Student("Sam", Arrays.asList(5, 7, 8)),
                new Student("Bob", Arrays.asList(5, 7, 9)),
                new Student("Marta", Arrays.asList(6, 9, 8)));

        List<Integer> studentsGrades = students.stream()
                .flatMap(human -> human.getGrades().stream())
                .toList();
        System.out.println(studentsGrades);
    }

    public static void taskFive() {
        System.out.println("\n" + "Task 5: ");
        List<String> stringList = new ArrayList<>();
        stringList.add("5");
        stringList.add("7");
        stringList.add("12");
        stringList.stream()
                .map(Integer::valueOf)
                .map(x -> x * x)
                .forEach(System.out::println);

    }
}
