package org.apframework.collection.set;

import java.util.TreeMap;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/7/25 11:59
 */
public class TreeMapSample {
    public static void main(String[] args) {
        // creating maps
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // populating tree map
        treeMap.put(2, "two");
        treeMap.put(1, "one");
        treeMap.put(3, "three");
        treeMap.put(6, "six");
        treeMap.put(5, "five");

        System.out.println("Getting tail map");
        System.out.println("Tail map values: " + treeMap.tailMap(3));
        System.out.println("Head map values: " + treeMap.headMap(3));
        System.out.println("First key is: " + treeMap.firstKey());
    }
}
