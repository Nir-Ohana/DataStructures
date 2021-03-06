package datastructures;

@SuppressWarnings("unchecked")
public class DyanmicArray<T> implements Iterable<T> {
    private T [] arr;
    private int len = 0;
    private int capacity;

    public DyanmicArray(){
        this(16);
    }

    public DyanmicArray(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity Given: " + capacity);
        }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){
        return len;
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public T get(int index){
        return arr[index];
    }

    public void set(int index, T elem){
        arr[index] = elem;
    }

    public void clear(){
        for(int i = 0; i < capacity; i++){
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem){
        if(len + 1 >= capacity){
            if(capacity == 0){
                capacity = 1;
            }
            else {
                capacity *= 2;
            }
            T[] new_arr = (T[]) new Object[capacity];
            for(int i = 0; i < len; i++){
                new_arr[i] = arr[i];
            }
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    public T removeAt(int index){
        if(index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T data = arr[index];
        T[] new_arr = (T[]) new Object[len - 1];
        for(int i = 0, j=0;i<len; i++, j++){
            // found the element to remove align indexes
            if (i == index){
                j--;
            }
            else{
                new_arr[j] = arr[i];
            }
        }
        arr = new_arr;
        capacity = len - 1;
        return data;
    }

    public boolean remove(Object obj){
        for(int i = 0; i < len; i++){
            if (arr[i].equals(obj)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        for (int i = 0; i < len; i++){
            if (arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    @Override public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<>() {
            int index = 0;
            public boolean hasNext(){
                return index < len;
            }
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override public String toString() {
        if(len == 0) {
            return "[]";
        }
        else{
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i = 0; i < len - 1; i++){
                sb.append(arr[i]).append(", ");
            }
            return sb.append(arr[len - 1]).append("]").toString();
        }
    }


}
