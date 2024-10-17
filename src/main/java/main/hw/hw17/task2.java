package main.hw.hw17;

import java.util.Scanner;
import java.util.function.Predicate;

public class task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array using space as delimiter: ");
        String[] members = sc.nextLine().split(" ");
        int sizeOfArray = members.length;
        int[] array = new int[sizeOfArray];

        Predicate<Integer> isPositive = x -> x > 0;
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = Integer.parseInt(members[i]);
            if (isPositive.test(array[i]))
                System.out.println(array[i] + " ");
        }
    }
}
