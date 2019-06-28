package com.jalasoft.minions.linkedlist;

/**
 * Created by DCABEROB on 5/7/2019.
 */
public class LinkedList<T> implements IList {
    Node<T> head;
    Node<T> tail;

	/**
	* method to add in the fisrt or head list.
	*/
    @Override
    public void add(Object node) {
        Node<T> newNode = new Node<T>((T) node);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

	/**
	* method to print to list.
	*/
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

	/**
	* method to remove in the fisrt or head list.
	*/
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

	/**
	* method to add in the last or tail list.
	*/
	@Override
    public void addLast(Object value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

	/**
	* method to add in the add in the index to sent.
	*/
	@Override
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
	
	/**
	* method to add in the add in front list.
	*/
	@Override
    public void addFront(Object value) {
       Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head =newNode;
        }
    }
	
	/**
	* method to remove index list.
	*/
	@Override
    public void remove(int index){
        Node current = head;
        for(int aux=1;aux<index;aux ++){
            current = current.next;
        }
        Node aux = current.next;
        current.next = aux.next;
        aux.next = null;

    }
	
	/**
	* method to remove the last list.
	*/
	@Override
    public void removeLast(){
        Node current = head;
        while(current.next !=tail){
            current = current.next;
        }
        current.next = null;
        tail= current;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public T getIndex(int index){
        Node current = head;
        for(int aux=1;aux<index;aux ++){
            current = current.next;
        }
        return (T) current;
    }
}

