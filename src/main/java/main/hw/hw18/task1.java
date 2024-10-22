package main.hw.hw18;

import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        List<Integer> listElements = new ArrayList<>();
        listElements.add(1);
        listElements.add(2);
        listElements.add(3);
        listElements.add(4);
        listElements.add(2);
        listElements.add(5);
        listElements.add(6);
        listElements.add(4);
        listElements.add(7);
        listElements.add(8);

        int sum = listElements.stream()
                .distinct()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x).sum();

        System.out.println(sum);
    }
}
