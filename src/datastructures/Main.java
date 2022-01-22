package datastructures;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linky = new LinkedList<>(new Node<>(1));
        linky.appendToEnd(1);
        linky.appendToEnd(1);
        linky.appendToEnd(1);
        linky.appendToEnd(1);
        linky.appendToEnd(1);
        linky.appendToEnd(3);
        linky.appendToEnd(3);
        linky.appendToEnd(3);
        linky.appendToEnd(1);
        linky.appendToEnd(1);
        linky.appendToEnd(3);
        linky.appendToEnd(1);
        Node<Integer> curr = linky.getHead();
        linky.deleteDupsWithoutExtraSpace();
        while(curr != null){
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }

    }
}
