package main;

import java.util.*;

public class lesson16 {

    public void ex(){
        //-----------------------------------------------------------------------

        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("1", "obj1");
        hashmap.put("2", "obj2");
        hashmap.put("3", "obj3");
        hashmap.get("3");
        SortedMap<String, String> sortedMap = new TreeMap<>();


        //-----------------------------------------------------------------------

        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(15, 0.75f, true) {{
            put(1, "obj1");
            put(15, "obj15");
            put(4, "obj4");
            put(38, "obj38");
        }};
        System.out.println("linkedHashMap - " + linkedHashMap);
        linkedHashMap.get(1);
        System.out.println("linkedHashMap - " + linkedHashMap);

        for (Map.Entry<Integer, String> integerStringEntry : linkedHashMap.entrySet()) {
            String variable = linkedHashMap.get(4);
        }

        System.out.println("linkedHashMap - " + linkedHashMap);
        //-----------------------------------------------------------------------

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(String::compareTo);

        priorityQueue.add("Andrew");
        priorityQueue.add("John");
        priorityQueue.add("Rob");

        while (!priorityQueue.isEmpty()) {
            System.out.println("priorityQueue - " + priorityQueue.remove());
        }

        //-----------------------------------------------------------------------

        Map<Integer, Integer> treeMap = new TreeMap<>(Map.of(1,1,3,4,5,6,7,8));
        treeMap.put(1,3);
        System.out.println("treeMap - " + treeMap);
        Set<String> set = new HashSet<>();
    }
}
