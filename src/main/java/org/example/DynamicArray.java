package org.example;

public class DynamicArray {

    private int[] items;
    private int count;

    public DynamicArray(int initialCapacity) {
        items = new int[initialCapacity];
    }

    public void insert(int item) {
        if (count == items.length) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }

            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }

        return -1;
    }

    public void reverse() {
        int temp = 0;
        for (int i = 0; i < count / 2; i++) {
            temp = items[i];
            items[i] = items[count - i - 1];
            items[count - i - 1] = temp;
        }
    }

    public int max() {
        int maxItem = 0;
        for (int i = 0; i < count; i++) {
            if (maxItem < items[i]) {
                maxItem = items[i];
            }
        }
        return maxItem;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

}
