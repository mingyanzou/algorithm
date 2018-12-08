package com.zmy.basic.sort;

public class BubbleSort {

    public static void main(String args[]) {
        int[] a = {6, 8, 4, 9, 3, 5, 7, 1, 2};
        sort(a);
    }

    private static void sort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            boolean isChanging = false;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] > arrays[j]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
                isChanging = true;
            }
            if (!isChanging) break;
        }

        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

}
