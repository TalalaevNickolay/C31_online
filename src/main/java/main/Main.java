package main;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("1234");
        s.add("123456");
        s.add("123456789");
        s.add("12");
        s.add("1");
        List<Integer> collect = s.stream()
                .sorted(Comparator.comparingInt(String::length))
                .filter(x -> x.length() > 3)
                .map(s1 -> Integer.parseInt(s1))
                .toList();
        System.out.println(collect);

        Calendar calendar = new GregorianCalendar();
        calendar.set(1, Calendar.JANUARY, 1789);


        s.removeIf(x -> x.length() > 5);

        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
    }
}
