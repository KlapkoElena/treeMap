package treeMap;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(10, "Ten");
        treeMap.put(8, "Eight");
        treeMap.put(6, "Six");
        treeMap.put(4, "Four");
        treeMap.put(2, "Two");
        treeMap.put(0, "Zero");

        System.out.println("Collection Map: " + treeMap.clone() +
                "\nSize Map: " + treeMap.size() +
                "\nIs there a value with key 10: " + treeMap.containsKey(10) +
                "\nOutput value by key 2: " + treeMap.get(2) +
                "\nThe first value of the collection: " + treeMap.firstEntry() +
                "\nReplacing the value under key 0: " + treeMap.replace(0, "Hundred") +
                "\nNew value under key 0: " + treeMap.get(0) +
                "\nCollection values up to key 4: " + treeMap.headMap(4) +
                "\nCollection values from key 6: " + treeMap.tailMap(6) +
                "\nDelete value under key 4: " + treeMap.remove(4) +
                "\nShow all collection keys: " + treeMap.keySet() +
                "\nIs the collection empty? " + treeMap.isEmpty() +
                "\nShow!!! " + treeMap.clone());

    }
}
