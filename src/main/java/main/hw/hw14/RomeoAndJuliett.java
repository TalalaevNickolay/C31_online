package main.hw.hw14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RomeoAndJuliett {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/romeo_and_juliett.txt";  // Путь к входному файлу
        String outputFilePath = "src/main/resources/output.txt"; // Путь к выходному файлу

        try {
            // Чтение содержимого файла
            String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            // Разделение текста на слова
            String[] words = content.split("\\W+"); // \\W+ разбивает по некорректным символам (разделителям)

            // Поиск самого длинного слова
            String longestWord = "";
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            // Запись самого длинного слова в выходной файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write(longestWord);
            }
            System.out.println("Самое длинное слово: " + longestWord);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
