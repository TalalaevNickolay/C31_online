package main.lesson18;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsEx {

    private final List<User> userList = Arrays.asList(
            new User(1, "Michael", "Robert", 37, "TR"),
            new User(2, "Mary", "Patricia", 11, "EN"),
            new User(3, "John", "Michael", 7, "FR"),
            new User(4, "Jennifer", "Linda", 77, "TR"),
            new User(5, "William", "Elizabeth", 23, "US"),
            new User(6, "Sue", "Jackson", 11, "IT"),
            new User(7, "Michael", "Tommy", 37, "EN")
    );

    public static void main(String... args) {
        StreamsEx sample = new StreamsEx();
        sample.test1();
        sample.test2();
        sample.test3();
        sample.test4();
        sample.test5();
        sample.test6();
        sample.test7();
        sample.test8();
        sample.test9();
    }

    private void test1() {
        System.out.println("Test 1");
        userList.stream().forEach(System.out::println);
    }

    private void test2() {
        System.out.println("Test 2");
        userList.stream()
                .map(u -> new User(
                        u.getId(),
                        "X " + u.getFirstName(),
                        "Y " + u.getLastName(),
                        u.getAge() + 10, u.getNationality()))
                .toList()
                .forEach(System.out::println);
    }

    private void test3() {
        System.out.println("Test 3");
        userList.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList()
                .forEach(System.out::println);
    }

    private void test4() {
        System.out.println("Test 4");
        userList.stream()
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(User::getFirstName)
                        .thenComparing(User::getLastName))
                .toList()
                .forEach(System.out::println);
    }

    private void test5() {
        System.out.println("Test 5");
        double averageAge = userList.stream()
                .mapToInt(User::getAge)
                .summaryStatistics()
                .getAverage();
        System.out.print("averageAge: " + averageAge);
        int maxFirstNameLenght = userList.stream()
                .mapToInt((value) -> {
                    return value.getFirstName().length();
                })
                .summaryStatistics()
                .getMax();
        System.out.println(" maxFirstNameLenght: " + maxFirstNameLenght);
    }

    private void test6() {
        System.out.println("Test 6");
        boolean isAllAgesGreaterThan6 = userList.stream()
                .allMatch(user -> user.getAge() > 6);
        System.out.println("isAllAgesGreaterThan6: " +     isAllAgesGreaterThan6);
    }

    private void test7() {
        System.out.println("Test 7");
        boolean isFirstCharS = userList.stream()
                .anyMatch(user -> user.getFirstName().charAt(0) == 'S');
        System.out.println("isFirstCharS " + isFirstCharS);
    }

    private void test8() {
        System.out.println("Test 8");
        List<User> list = userList.stream()
                .toList();
        Set<User> set = userList.stream()
                .collect(Collectors.toSet());
        List<User> linkedList = userList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        Map<Long, User> map = userList.stream()
                .collect(Collectors.toMap(user -> user.getId(), user -> user));
    }

    private void test9() {
        long countDifferentNationalites = userList.stream()
                .map(User::getNationality)
                .distinct()
                .count();
        System.out.println("countDifferentNationalites: " + countDifferentNationalites);
    }
}