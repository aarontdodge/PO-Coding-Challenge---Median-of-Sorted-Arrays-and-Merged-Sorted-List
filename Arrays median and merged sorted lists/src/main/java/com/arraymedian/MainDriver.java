package com.arraymedian;

public class MainDriver {

    // Given 2 sorted arrays of lengths m and n, return the median of the arrays with run time complexity O(log(m+n)

    // Since the arrays are already sorted, we don't need a recursive merge sort. We only need one iteration
    public static int[] mergeSortedArrays(int[] arr1, int[]arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int left = 0;
        int right = 0;
        int mergedIndex = 0;

        while (left < arr1.length && right < arr2.length) {
            if (arr1[left] <= arr2[right]) {
                merged[mergedIndex] = arr1[left];
                left++;
            } else {
                merged[mergedIndex] = arr2[right];
                right++;
            }
            mergedIndex++;
        }
        while (left < arr1.length) {
            merged[mergedIndex] = arr1[left];
            left++;
            mergedIndex++;
        }
        while (right < arr2.length) {
            merged[mergedIndex] = arr2[right];
            right++;
            mergedIndex++;
        }
        return merged;
    }

    public static double sortedArraysMedian(int[] arr1, int[] arr2){
        int[] mergedList = mergeSortedArrays(arr1, arr2);
        double median;
        if (mergedList.length % 2 == 0) { // If the combined array has an even length, return the average of the 2 middle numbers.
            int sum = mergedList[mergedList.length / 2] + mergedList[mergedList.length / 2 - 1];
            median = (double) sum / 2;
        } else {
            median = mergedList[mergedList.length / 2];
        }
        return median;
    }

    // Otherwise, return the middle number

    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2,5};
        System.out.println(sortedArraysMedian(arr1, arr2));
    }
}
