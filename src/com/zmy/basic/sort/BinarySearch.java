package com.zmy.basic.sort;

public class BinarySearch {

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19};
        //int index = binarySearch(a, 10);
        int[] b = {1, 2, 3, 4, 7, 8, 8, 8, 8, 8, 14, 15, 16, 17, 18, 19};
        //int index = bsearchInternally(a, 0, a.length, 10);
        //int index = lastBsearch(b, 8);
        int index = firstLargeBsearch(a , 8);
        //int index = lastSmallBsearch(a , 8);
        System.out.println(index);
    }

    private static int binarySearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = high + 1;
            }
        }
        return -1;
    }


    private static int bsearchInternally(int a[], int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

    /**
     * 查找第一个出现给的值
     */
    private static int firstBsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 最后一个出现给定的值
     */
    private static int lastBsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == high || a[mid + 1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个给定大于，等于该值的元素
     */
    private static int firstLargeBsearch(int a[], int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 最后一个小于等于该值的元素
     */
    private static int lastSmallBsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (mid == high || a[mid + 1] > value) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
