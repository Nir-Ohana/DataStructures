package datastructures;

public class LinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> headLink;
    private Node<T> tail = null;


    public LinkedList(Node<T> head) {
        this.headLink = head;
    }

    // Empty the linked list
    // O(n) time
    public void clear() {
        Node<T> runner = this.headLink;
        while (runner != null) {
            Node<T> next = runner.getNext();
            runner.setPrev(null);
            runner.setNext(null);
            runner = next;
        }
        this.headLink = this.tail = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node<T> getHead() {
        return this.headLink;
    }

    public int length() {
        int count = 0;
        Node<T> runner = this.headLink;

        while (runner != null) {
            count++;
            runner = runner.getNext();
        }
        return count;
    }

    public void appendToHead(T item) {
        if (isEmpty()) {
            this.headLink = this.tail = new Node<>(item, null, null);
        } else {
            this.headLink.setPrev(new Node<>(item, null, this.headLink));
            this.headLink = this.headLink.getPrev();
        }
        this.size += 1;
    }

    public void appendToTail(T item) {
        if (isEmpty()) {
            headLink = tail = new Node<>(item, null, null);
        } else {
            tail.setNext(new Node<>(item, tail, null));
            tail = tail.getNext();
        }
        size += 1;
    }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return this.headLink.getValue();
    }

    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return this.tail.getValue();
    }

    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");

        T value = this.headLink.getValue();
        this.headLink = this.headLink.getNext();
        size -= 1;

        if (isEmpty()) {
            tail = null;
        } else {
            this.headLink.setPrev(null);
        }

        return value;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");

        T value = this.tail.getValue();
        this.tail = this.tail.getPrev();
        size -= 1;

        if (isEmpty()) {
            this.headLink = null;
        } else {
            this.tail.setNext(null);
        }
        return value;
    }

    private T remove(Node<T> node) {
        if (node.getPrev() == null)
            return removeFirst();
        if (node.getNext() == null)
            return removeLast();

        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());

        T data = node.getValue();

        node.setValue(null);
        node.setPrev(null);
        node.setNext(null);
        node.setValue(null);
        size -= 1;

        return data;
    }

    public T removeAt(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException();

        int i;
        Node<T> runner;

        // If index in first half search from head
        if (index < this.size / 2) {
            for (i = 0, runner = this.headLink; i != index; i++)
                runner = runner.getNext();
        } else {
            for (i = this.size - 1, runner = this.tail; i != index; i--)
                runner = runner.getPrev();
        }

        return remove(runner);
    }

    public boolean remove(Object obj) {
        Node<T> runner;

        if (obj == null) {
            for (runner = this.headLink; runner != null; runner = runner.getNext()) {
                if (runner.getValue() == null) {
                    remove(runner);
                    return true;
                }
            }
        } else {
            for (runner = this.headLink; runner != null; runner = runner.getNext()) {
                if (obj.equals(runner.getValue())) {
                    remove(runner);
                    return true;
                }
            }
        }

        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> runner;

        if (obj == null) {
            for (runner = this.headLink; runner != null; runner = runner.getNext(), index++) {
                if (runner.getValue() == null) {
                    return index;
                }
            }
        } else {
            for (runner = this.headLink; runner != null; runner = runner.getNext(), index++) {
                if (obj.equals(runner.getValue())) {
                    return index;
                }
            }

        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private Node<T> runner = headLink;

            @Override
            public boolean hasNext() {
                return runner != null;
            }

            @Override
            public T next() {
                T value = runner.getValue();
                runner = runner.getNext();
                return value;
            }
        };
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> runner;
        sb.append("[");
        for(runner = headLink; runner.getNext() != null; runner = runner.getNext()){
            sb.append(runner.getValue().toString()).append(", ");
        }
        sb.append(runner.getValue()).append("]");
        return sb.toString();
    }

}
