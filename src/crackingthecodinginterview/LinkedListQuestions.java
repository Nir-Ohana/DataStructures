package crackingthecodinginterview;

import datastructures.LinkedList;
import datastructures.Node;

import java.util.HashSet;

public class LinkedListQuestions<T> {
    /* O(N) run time
       O(N) space
       We save a hash set to check if the current value is already in it,
       if so we delete the node.
       2.1 Remove Duplicates
     */
    public void deleteDupsWithExtraSpace(LinkedList list) {
        HashSet<T> set = new HashSet<>();
        Node<T> previous = null;
        Node<T> runner = list.getHead();
        while (runner != null) {
            if (set.contains(runner.getValue())) {
                previous.setNext(runner.getNext());
            } else {
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
    2.1 Remove Duplicates
     */
    public void deleteDupsWithoutExtraSpace(LinkedList list) {
        Node<T> current = list.getHead();
        while (current != null) {
            Node<T> runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getValue() == current.getValue()) {
                    runner.setNext(runner.getNext().getNext());
                    if (runner.getNext() != null) {
                        runner.getNext().setPrev(runner);
                    }
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

    /*
    We only have access to the Node to delete,
    make this node replace the next node, we essentially deleted the current node.
    O(1) runtime
    O(1) space
    2.3 Delete Middle Node
     */

    /*
    We are moving two pointers simultaneously, the runner is k nodes apart and will hit the end of list
    when the kth element is at the kth element from the end of the list.
    O(N) runtime
    O(1) space
    2.2 Return Kth to Last
     */
    public Node<T> KthLastElementSinglyLinked(int k, LinkedList list) {
        Node<T> kth = list.getHead();
        Node<T> runner = list.getHead();
        for (int i = 0; i < k; i++) {
            // We entered the for loop when k is bigger than the list's length
            if (runner == null) {
                return null;
            }
            runner = runner.getNext();
        }

        while (runner != null) {
            kth = kth.getNext();
            runner = runner.getNext();
        }
        return kth;
    }

    public boolean deleteMiddleNode(Node<T> nodeToDelete) {
        // node to delete is null or this is the last node in the list.
        if (nodeToDelete == null || nodeToDelete.getNext() == null) {
            return false;
        }
        nodeToDelete.setValue(nodeToDelete.getNext().getValue());
        nodeToDelete.setNext(nodeToDelete.getNext().getNext());
        if (nodeToDelete.getNext() != null) {
            nodeToDelete.getNext().setPrev(nodeToDelete); // clean up for doubly linked list
        }
        return true;
    }

    //    public LinkedList<T> partitionList(T x){
//        LinkedList<T> partition = new LinkedList<>();
//        Node<T> runner = this.headLink;
//        while(runner != null){
//            if(runner.getValue() < x){
//                partition.appendToEnd(runner);
//            }
//            runner = runner.getNext();
//        }
//        runner = this.headLink;
//        while(runner != null){
//            if(runner.getValue() >= x){
//                partition.appendToEnd(runner);
//            }
//            runner = runner.getNext();
//        }
//        return partition;
//    }
}
