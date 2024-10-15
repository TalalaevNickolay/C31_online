package main.hw.hw16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] array = line.split(" ");

        Map<String, Boolean> checkingVal = new HashMap<>();
        for (String s : array) {
            checkingVal.put(s, checkingVal.containsKey(s));
        }

        System.out.println(checkingVal);
    }
}