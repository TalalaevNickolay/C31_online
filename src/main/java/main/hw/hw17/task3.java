package main.hw.hw17;

import java.util.Scanner;
import java.util.function.Function;

public class task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sum in BYN: ");
        String sumBYN = sc.nextLine();
        String[] parts = sumBYN.split(" ");
        Function<String, Double> converter = x -> Double.parseDouble(x) / 3.28;

        Double sumUSD = converter.apply(parts[0]);

        System.out.println(sumUSD + " USD");
    }
}

