package datastructures;

import java.util.HashSet;

public class LinkedList<T> {
    private Node<T> headLink;

    public LinkedList(Node<T> head){
        this.headLink = head;
    }

    public Node<T> getHead(){
        return this.headLink;
    }

    public boolean deleteNodeWithValue(T value){
        Node<T> runner = this.headLink;

        // Change head
        if(runner.getValue() == value){
            this.headLink = runner.getNext();
            return true;
        }

        while(runner != null){
            if(runner.getValue() == value){
                if(runner.getPrev() != null){
                    runner.getPrev().setNext(runner.getNext());
                }
                if(runner.getNext() != null){
                    runner.getNext().setPrev(runner.getPrev());
                }
            return true;
            }
            runner = runner.getNext();
        }
        return false;
    }

    public void appendToEnd(T item){
        Node<T> newItem = new Node<T>(item);
        Node<T> current = this.headLink;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newItem);
        newItem.setPrev(current);
    }

    /* O(N) run time
       O(N) space
       We save a hash set to check if the current value is already in it,
       if so we delete the node.
     */
    public void deleteDupsWithExtraSpace(){
        HashSet<T> set = new HashSet<>();
        Node<T> previous = null;
        Node<T> runner = this.headLink;
        while(runner != null){
            if (set.contains(runner.getValue())){
                previous.setNext(runner.getNext());
            }
            else{
                set.add(runner.getValue());
                previous = runner;
            }
            runner = runner.getNext();
        }
    }

    /*
    O(N^2) runtime
    O(1) space
    Running with a pointer on the linked list and comparing to the current pointer
    deleting if equals.
     */
    public void deleteDupsWithoutExtraSpace(){
        Node<T> current = this.headLink;
        while (current != null){
            Node<T> runner = current;
            while(runner.getNext() != null){
                if (runner.getNext().getValue() == current.getValue()){
                    runner.setNext(runner.getNext().getNext());
                    if(runner.getNext() != null){
                        runner.getNext().setPrev(runner);
                    }
                }
                else{
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }
}
