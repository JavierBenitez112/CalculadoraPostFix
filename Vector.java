public class Vector<T> implements Stack<T> {
    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Vector() {
        this(DEFAULT_CAPACITY);
    }

    public Vector(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        size = 0;
    }

    public void push(T item) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("El Stack esta vacio");
        }
        T item = array[--size];
        array[size] = null;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
