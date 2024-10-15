package main.hw.hw16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] array = line.split(" ");

        Map<String, String> checkingVal = new HashMap<>();

        for (String s : array) {
            checkingVal.put(s.substring(0, 1), s.substring(s.length() - 1));
        }

        System.out.println(checkingVal);
    }
}