package datastructures;

public class Node<T> {
    private T value;
    private Node<T> next = null;
    private Node<T> prev = null;

    public Node(T value){
        this.value = value;
    }

    public Node(T value, Node<T> prev, Node<T> next){
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }




}
