package main.hw.hw16;

import java.util.LinkedList;

public class Task3 {

    public static void main(String[] args) {
        String input1 = "({[()]})"; // сбалансирована
        String input2 = "{[(])}";   // не сбалансирована
        System.out.println(isBalanced(input1));
        System.out.println(isBalanced(input2));
    }

    public static boolean isBalanced(String inputString) {
        LinkedList<Character> queue = new LinkedList<>();
        for (char current: inputString.toCharArray()) {
            if (current == '(' || current == '[' || current == '{') {
                queue.offer(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (queue.isEmpty()) {
                    return false; // Закрывающая скобка без соответствующей открывающей
                }
                char top = queue.removeLast();
                if (!isMatchingPair(top, current)) {
                    return false; // Скобки не совпадают
                }
            }
        }
        return queue.isEmpty(); // Если стек пуст, значит сбалансирован
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
