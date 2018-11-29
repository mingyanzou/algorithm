package com.zmy.basic;

public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        size = 0;
    }

    //无参构造方法
    public GenericArray() {
        this(10);
    }

    //获取数组容量
    public int capacity() {
        return data.length;
    }

    //获取当前元素个数
    public int size() {
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //修改元素值，根据index
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    //获取对应 index值
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    //查看数组是否包含元素
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //获取对应元素下标，未找到，返回 -1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //在index的位置插入e
    public void insert(int index, T e) {
        checkIndex(index);
        if (size == data.length) {
            resize(2 * size);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //向数组头插入元素
    public void insertHead(T e) {
        insert(0, e);
    }

    //向数组尾插入元素
    public void insertTail(T e) {
        insert(size, e);
    }

    //删除 index 位置的元素，并返回
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
    }

    //删除第一个元素
    public void removeFirst() {
        remove(0);
    }

    //删除末尾元素
    public void removeTail() {
        remove(size - 1);
    }
    //从数组中删除指定元素

    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    //扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newdate = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newdate[1] = data[i];
        }
        data = newdate;
    }

    //检查index是否合格
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            new IllegalArgumentException("index不合法，请输入正确index");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, and capacity = %d \n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String args[]) {
        GenericArray<String> genericArray = new GenericArray<>(5);
        genericArray.insert(0, "a");
        genericArray.insert(1, "b");
        genericArray.insert(2, "c");
        genericArray.insert(1,"d");
        System.out.println(genericArray.toString());
    }
}
