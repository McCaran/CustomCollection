package andersen.Georgiiev;

import java.util.Iterator;
import java.util.Objects;

public class CustomCollection<T extends Number> implements Iterable<T>{
    private final Object[] EMPTY_ARRAY = {};
    private final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    public CustomCollection() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public CustomCollection(int size) {
        if (size > 0) {
            elements = new Object[size];
        } else {
            throw new IllegalArgumentException("Неверный размер: " + size);
        }
    }

    public void add(T element) {
        if (size == capacity) {
            grow();
        }
        elements[size++] = element;
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, size+1);
        if (size == capacity) {
            grow();
        }
        System.arraycopy(elements, index, elements, index+1, size-index);
        elements[index] = element;
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T)elements[index];
    }

    public boolean remove(T element) {
        if (!contains(element)) return false;
        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (elements[i] == null) {
                    delete(i);
                }
            } else if (elements[i].equals(element)) {
                delete(i);
            }
        }
        return true;
    }

    public boolean removeByIndex(int index) {
        return true;
    }

    public boolean contains(T element) {
        if (element == null) {
            for (Object o: elements) {
                if (o == null) return true;
            }
        } else for (Object o: elements) {
            if (o == null) continue;
            if (o.equals(element)) return true;
        }
        return false;
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public void trimToSize() {

    }

    public double getAverage() {
        return 0;
    }

    public T getMax() {
        return null;
    }

    public T getMin() {
        return null;
    }

    public int getSize() {
        return size;
    }

    private void delete(int index) {
        if (index == size-1) {
            elements[--size] = null;
        }

    }

    private void grow() {
        capacity = (capacity*3)/2+1;
        Object[] newArray = new Object[capacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i] + ", ");
        }
        if (size > 0) {
            sb.delete(sb.length()-2, sb.length());
        }
        sb.append("}");
        return sb.toString();
    }
}
