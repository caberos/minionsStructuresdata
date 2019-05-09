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

    public void addLast(Object value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void addIndex(int index, Object value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFront(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next;
            }
            if (current.next == null) {
                tail = newNode;
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    private void addFront(Object value) {
       Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head =newNode;
        }
    }

    public void remove(int index){
        Node current = head;
        for(int aux=1;aux<index;aux ++){
            current = current.next;
        }
        Node aux = current.next;
        current.next = aux.next;
        aux.next = null;

    }
    public void removeLast(){
        Node current = head;
        while(current.next !=tail){
            current = current.next;
        }
        current.next = null;
        tail= current;
    }
}
