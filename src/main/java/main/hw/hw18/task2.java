package main.hw.hw18;

//  Задача *:
//        Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
//        этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
//        Среди отобранных значений отобрать только те, которые имеют нечетное количество
//        букв в имени. После чего вернуть список List имен, записанных буквами задом наперед

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class task2 {
    public static void main(String[] args) {
        Map<Integer, String > map = Map.of(1, "Alex", 5, "Slava", 3, "George", 9, "Maria",
                7, "Stas", 11, "Vlad", 13, "Sonya");
        Set<Integer> integers = Set.of(1, 2, 5, 8, 9, 13);
        List<String> collect = map.entrySet().stream()
                .filter(entry -> integers.contains(entry.getKey()))
                .filter(entry -> entry.getValue().length() % 2 != 0)
                .map(entry -> new StringBuilder(entry.getValue()).reverse().toString())
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
