package datastructures;
import crackingthecodinginterview.LinkedListQuestions;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linky = new LinkedList<>(new Node<>(1));
        LinkedListQuestions<Integer> algo = new LinkedListQuestions<>();
        linky.appendToTail(1);
        linky.appendToTail(3);
        linky.appendToTail(5);
        linky.appendToTail(5);
        linky.appendToTail(5);
        algo.deleteDupsWithoutExtraSpace(linky);
        Node<Integer> curr = linky.getHead();
        System.out.println(linky);

    }
}
