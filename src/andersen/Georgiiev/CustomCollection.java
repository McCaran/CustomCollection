package andersen.Georgiiev;

import java.util.Iterator;
import java.util.Objects;

public class CustomCollection<T extends Number> implements Iterable<T>{
    private final int DEFAULT_CAPACITY = 10;
    private Number[] elements;
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    public CustomCollection() {
        elements = new Number[DEFAULT_CAPACITY];
    }

    public CustomCollection(int size) {
        if (size > 0) {
            elements = new Number[size];
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
            } else if (elements[i].toString().equals(element.toString())) {
                delete(i);
            }
        }
        return true;
    }

    public void removeByIndex(int index) {
        Objects.checkIndex(index, size);
        delete(index);
    }

    public boolean contains(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return true;
            }
        } else for (int i = 0; i < size; i++) {
            if (elements[i] == null) continue;
            if (elements[i].toString().equals(element.toString())) return true;
        }
        return false;
    }

    public void clear() {
        elements = new Number[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public void trimToSize() {
        System.out.println("Изначальный размер: " + capacity);
        Number[] newArray = new Number[size];
        System.arraycopy(elements,0, newArray, 0, size);
        elements = newArray;
        capacity = newArray.length;
        System.out.println("Новый размер:    " + capacity);
    }

    public Double getAverage() {
        if (isEmpty()) {
            return null;
        }
        Double average = 0.0;
        for (Double value: getNumbers()) {
            average += value;
        }
        return average/size;
    }

    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        Double max = Double.valueOf(elements[0].toString());
        int maxIndex = 0;
        Double[] numbers = getNumbers();
        for (int i = 1; i < size; i++) {
            if (numbers[i] == null) continue;
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }

    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        Double min = Double.valueOf(elements[0].toString());
        int minIndex = 0;
        Double[] numbers = getNumbers();
        for (int i = 1; i < size; i++) {
            if (numbers[i] == null) continue;
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }
        return get(minIndex);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private Double[] getNumbers() {
        Double[] numbers = new Double[size];
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) numbers[i] = null;
            else numbers[i] = Double.valueOf(elements[i].toString());
        }
        return numbers;
    }

    private void delete(int index) {
        if (index == size-1) {
            elements[--size] = null;
        } else {
            System.arraycopy(elements,index+1, elements, index, size-index-1);
            elements[--size] = null;
        }
    }

    private void grow() {
        capacity = (capacity*3)/2+1;
        Number[] newArray = new Number[capacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                return (cursor < size);
            }

            @Override
            public T next() {
                if (cursor < elements.length) {
                    return get(cursor++);
                }
                return null;
            }
        };
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
