package main.lesson18;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String s1 = new String("oeiajh, b, c,d,e");
        String s2 = new String("f,g,h,j,k");
        String s3 = new String("1, 2, 3,4,5");

        List<String> asList = Arrays.asList(s1, s2, s3);
        List<Integer> ints = Arrays.asList(1,1,1,1,2,3,4,5);
        List<String> stringList = asList.stream().flatMap(
                (p) -> Arrays.asList(p.split(",")).stream()).collect(Collectors.toList());
        System.out.println(ints.stream().reduce((p, q) -> p + q).get());
        System.out.println(stringList);
        sample.userList.stream()
                .filter(user -> user.getAge() > 10)
                .sorted(Comparator.comparing(User::getAge).reversed())
                .map(user -> user.getFirstName())
                .filter(name -> name.startsWith("M"))
                .collect(Collectors.toList());

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
                .sorted(Comparator.comparing(user -> user.getAge()))
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
                .mapToInt((value) -> value.getFirstName().length())
                .summaryStatistics()
                .getMax();
        System.out.println(" maxFirstNameLenght: " + maxFirstNameLenght);
    }

    private void test6() {
        System.out.println("Test 6");
        boolean isAllAgesGreaterThan6 = userList.stream()
                .allMatch(user -> user.getAge() > 6);
        System.out.println("isAllAgesGreaterThan6: " + isAllAgesGreaterThan6);
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
