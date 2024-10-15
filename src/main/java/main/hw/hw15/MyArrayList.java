package main.hw.hw15;

import java.util.Objects;

public class MyArrayList<T> {
    private final Integer START_ARRAY_SIZE = 10;
    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[START_ARRAY_SIZE];
    }

    public void add(T element) {
        if (size == array.length) {
            T[] temp = (T[]) new Object[size * 2];
            size++;
            temp[size] = element;
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
                array = temp;
            }
        } else {
            size++;
            array[size] = element;
        }
    }

    public void delete(T element) {
        boolean elementFound = false;
        int deletedIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                array[i] = null;
                elementFound = true;
                deletedIndex = i;
                break;
            }
        }
        if (elementFound) {
            T[] temp = (T[]) new Object[--size];
            for (int i = deletedIndex; i < temp.length; i++) {
                temp[i] = array[i + 1];
            }
        }
    }

    public T get(int index) {
        return array[index];
    }

    public boolean contains(T element) {
        for (T t : array) {
            if (t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (T t : array) {
            t = null;
        }
    }
}
