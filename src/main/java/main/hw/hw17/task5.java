package main.hw.hw17;

import java.util.Scanner;
import java.util.function.Supplier;

public class task5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter anything you want to reverse: ");
        StringBuilder string = new StringBuilder(sc.nextLine());

        Supplier<StringBuilder> reversedString = () -> string.reverse();

        System.out.println(reversedString.get());
    }
}
