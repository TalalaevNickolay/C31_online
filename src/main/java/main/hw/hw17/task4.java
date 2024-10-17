package main.hw.hw17;

import java.util.Scanner;
import java.util.function.Consumer;

public class task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sum in BYN: ");
        String sumBYN = sc.nextLine();
        String[] input = sumBYN.split(" ");
        Consumer<String> convertAndPrintResult = x -> System.out.println((Double.parseDouble(x) / 3.28) + " USD");

        convertAndPrintResult.accept(input[0]);
    }
}

