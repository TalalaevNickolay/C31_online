package main.hw.hw17;

import java.time.LocalDate;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your birthday in format yyyy-mm-dd ");
        String birthday = sc.nextLine();

        LocalDate date = LocalDate.parse(birthday);

        LocalDate after100years = date.plusYears(100);

        System.out.println(after100years);
    }
}

