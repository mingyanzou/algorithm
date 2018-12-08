package com.zmy.basic.sort;

public class InsertionSort {
    public static void main(String args[]) {
        int[] a = {6, 8, 4, 9, 3, 5, 7, 1, 2};
        sort(a);
    }

    private static void sort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int value = arrays[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arrays[j] > value) {
                    arrays[j + 1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[j + 1] = value;
        }
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

}
