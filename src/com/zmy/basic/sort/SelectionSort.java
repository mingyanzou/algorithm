package com.zmy.basic.sort;

public class SelectionSort {
    public static void main(String args[]) {
        int[] a = {6, 8, 4, 9, 3, 5, 7, 1, 2};
        sort(a);
    }

    private static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
