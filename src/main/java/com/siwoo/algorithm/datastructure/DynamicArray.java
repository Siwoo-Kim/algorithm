package com.siwoo.algorithm.datastructure;

/**
 * Created by sm123tt@gmail.com on 2019-09-15
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class DynamicArray {

    private int size;
    private int capacity;
    private Object[] array;

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
    }
    public DynamicArray() {
        this.capacity = 3;
        this.array = new Object[3];
    }

    public void add(Object el) {
        if (size == capacity) {
            int newCapacity = size << 1;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            capacity = newCapacity;
        }
        array[size++] = el;
    }
}
