package java.com.jalasoft.minions.linkedlist;

/**
 * Created by DCABEROB on 5/7/2019.
 */
public class LinkedList<T> implements IList {
    Node<T> head;
    Node<T> tail;

    @Override
    public void add(Object nude) {
        Node<T> newNode = new Node<T>((T) nude);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public void printList() {
        if (head != null) {
            Node node = head;
            while (node != tail) {
                System.out.printf(String.valueOf(node.value));
            }
        } else
            System.out.printf("List is null");
    }

    @Override
    public void removeFirst() {
        if (head != null && head.next != null) {
            Node newHead = head.next;
            head.next = null;
            head = newHead;
        } else {
            if (head.next == null) {
                head = null;
                tail = null;
            }
        }
    }
}
