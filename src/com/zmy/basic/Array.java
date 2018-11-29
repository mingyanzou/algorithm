package com.zmy.basic;

/**
 * int 类型实现数组
 */
public class Array {
    public int data[];
    public int count;
    public int n;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.count = 0;
        this.n = capacity;
    }

    public int find(int index) {
        if (index < 0 || index > count) {
            System.out.println("非法索引");
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (count == n){
            System.out.println("没有可插入的位置");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("非法索引");
            return false;
        }
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index > count) {
            System.out.println("非法索引");
            return false;
        }

        for (int i = index; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i] + " ");
        }
    }

    public static void main(String args[]) {
        Array array = new Array(5);
        array.insert(0, 2);
        array.insert(1, 5);
        array.insert(0, 2);
        array.insert(2, 3);
        array.insert(3, 8);
        array.delete(4);
        System.out.println("find index 4 = "+ array.find(4));
//        array.insert(4, 9);
        array.printAll();
    }
}
