package com.mergelists;

import java.util.LinkedList;
import java.util.List;

public class MainDriver {
    // You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    // Merge all the linked-lists into one sorted linked-list and return it.

    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        // This can be done similarly to the merging done in the other coding challenge
        LinkedList<Integer> merged = new LinkedList<>();
        int left = 0;
        int right = 0;

        while (left < list1.size() && right < list2.size()) {
            if (list1.get(left) <= list2.get(right)) {
                merged.add(list1.get(left));
                left++;
            } else {
                merged.add(list2.get(right));
                right++;
            }
        }
        while (left < list1.size()) {
            merged.add(list1.get(left));
            left++;
        }
        while (right < list2.size()) {
            merged.add(list2.get(right));
            right++;
        }
        return merged;
    }

    public static void main(String[] args) {

        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new LinkedList<>();
        list3.add(2);
        list3.add(6);

        List<Integer>[] listArray = new LinkedList[3];
        listArray[0] = list1;
        listArray[1] = list2;
        listArray[2] = list3;


        List<Integer> merged = listArray[0];

        for (int i = 1; i < listArray.length; i++) {
            merged = mergeLists(merged, listArray[i]);
        }

        System.out.println(merged);

    }
}
