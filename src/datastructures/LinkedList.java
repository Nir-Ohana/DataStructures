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

    public int length(){
        int count = 0;
        Node<T> runner = this.headLink;

        while(runner != null){
            count++;
            runner = runner.getNext();
        }
        return count;
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
        Node<T> newItem = new Node<>(item);
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
       2.1 Remove Dups
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
    2.1 Remove Dups
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

    /*
    We are moving two pointers simultaneously, the runner is k nodes apart and will hit the end of list
    when the kth element is at the kth element from the end of the list.
    O(N) runtime
    O(1) space
    2.2 Return Kth to Last
     */
    public Node<T> KthLastElementSinglyLinked(int k) {
        Node<T> kth = this.headLink;
        Node<T> runner = this.headLink;
        for(int i=0; i<k; i++) {
            // We entered the for loop when k is bigger than the list's length
            if (runner == null) {
                return null;
            }
            runner = runner.getNext();
        }

        while(runner != null){
            kth = kth.getNext();
            runner = runner.getNext();
        }
        return kth;
    }

}
